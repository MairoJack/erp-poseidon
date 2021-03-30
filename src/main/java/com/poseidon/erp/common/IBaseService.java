package com.poseidon.erp.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author mario on 2020/9/21.
 */
public interface IBaseService<T extends BaseEntity, DTO extends BaseDTO> extends IService<T> {

    /**
     * 分页
     */
    IPage<T> page(Page<T> page, BaseSearch<T> search);

    /**
     * 列表
     */
    List<T> list(BaseSearch<T> search);

    /**
     * 详情
     */
    T get(Long id);

    /**
     * 新增
     */
    void create(DTO dto);

    /**
     * 修改
     */
    void modify(Long id, DTO dto);

    /**
     * 删除
     */
    void delete(Long id);


}
