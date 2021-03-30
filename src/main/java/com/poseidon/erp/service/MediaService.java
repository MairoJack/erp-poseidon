package com.poseidon.erp.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import com.poseidon.erp.bean.dto.MediaDTO;
import com.poseidon.erp.bean.entity.Media;
import com.poseidon.erp.bean.enums.MediaType;
import com.poseidon.erp.bean.vo.MediaVO;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.MediaDao;
import com.poseidon.erp.utils.FileUtils;
import com.poseidon.erp.utils.ResponseCode;
import lombok.SneakyThrows;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * 媒体  Service
 *
 * @author mario on 2020-11-02
 */
@Service
@Transactional
public class MediaService extends BaseService<MediaDao, Media, MediaDTO> {

    public MediaService() {
        super(Media.class, ResponseCode.MEDIA_NOT_FOUND);
    }

    @Override
    protected void checkExist(Media entity, MediaDTO dto) {

    }

    /**
     * 上传
     */
    @SneakyThrows
    public MediaVO upload(MultipartFile file) {
        String md5 = DigestUtils.md5Hex(file.getBytes());
        Media media = super.getOne(Wrappers.<Media>lambdaQuery().eq(Media::getMd5, md5));
        if (ObjectUtil.isNotNull(media)) {
            return new MediaVO(media.getId(), media.getName());
        }
        String fileName = FileUtils.upload(file);
        media = new Media();
        media.setMd5(md5);
        media.setType(MediaType.IMAGE);
        media.setName(fileName);
        super.save(media);
        return new MediaVO(media.getId(), fileName);
    }

    /**
     * 根据多个ID返回列表
     */
    public List<Media> list(List<Long> ids) {
        if (ids.isEmpty()) {
            return Lists.newArrayList();
        }
        return baseMapper.selectList(Wrappers.<Media>lambdaQuery().in(Media::getId, ids));
    }

    /**
     * 删除图片
     */
    public void delete(String name) {
        if (super.remove(Wrappers.<Media>lambdaQuery().eq(Media::getName, name))) {
            FileUtils.delete(name);
        }
    }

}
