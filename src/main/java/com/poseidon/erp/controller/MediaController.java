package com.poseidon.erp.controller;

import com.google.common.collect.Lists;
import com.poseidon.erp.bean.vo.MediaVO;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.service.MediaService;
import com.poseidon.erp.utils.R;
import com.poseidon.erp.utils.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 媒体控制器
 *
 * @author mario on 2020-11-02
 */
@Api(value = "媒体管理", tags = "媒体管理")
@RestController
@RequestMapping("medias")
public class MediaController {

    private final MediaService service;

    public MediaController(MediaService service) {
        this.service = service;
    }

    @ApiOperation(value = "多文件上传")
    @PostMapping("multi")
    public R<List<MediaVO>> save(MultipartFile[] files) {
        if (files.length <= 0 || files.length > 5) {
            throw new BusinessException(ResponseCode.MEDIA_UPLOAD_LIMIT);
        }
        List<MediaVO> list = Lists.newArrayList();
        for (MultipartFile file : files) {
            list.add(service.upload(file));
        }
        return R.ok(list);
    }

    @ApiOperation(value = "单文件上传")
    @PostMapping("single")
    public R<MediaVO> save(MultipartFile file) {
        return R.ok(service.upload(file));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{name}")
    public R<?> delete(@PathVariable String name) {
        service.delete(name);
        return R.ok();
    }


}
