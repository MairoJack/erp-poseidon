package com.poseidon.erp.common;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poseidon.erp.utils.Assert;
import com.poseidon.erp.utils.ResponseCode;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author mario on 2020/9/21.
 */
@AllArgsConstructor
public abstract class BaseService<M extends BaseMapper<T>, T extends BaseEntity, DTO extends BaseDTO> extends ServiceImpl<M, T> implements IBaseService<T, DTO> {

    private final Class<T> clazz;
    private final ResponseCode notFound;

    @Override
    public IPage<T> page(Page<T> page, BaseSearch<T> search) {
        return super.page(page, search.query());
    }

    @Override
    public List<T> list(BaseSearch<T> search) {
        return super.list(search.query());
    }

    @Override
    public T get(Long id) {
        return Assert.notFound(super.getById(id), notFound);
    }

    @Override
    @Transactional
    public void create(DTO dto) {
        T t = ReflectUtil.newInstance(clazz);
        checkExist(t, dto);
        BeanUtil.copyProperties(dto, t, false);
        createExtend(t);
        super.save(t);
        afterCreate(t, dto);
    }

    @Override
    @Transactional
    public void modify(Long id, DTO dto) {
        T t = Assert.notFound(super.getById(id), notFound);
        checkExist(t, dto);
        BeanUtil.copyProperties(dto, t, false);
        modifyExtend(t);
        super.updateById(t);
        afterModify(t, dto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        T t = Assert.notFound(super.getById(id), notFound);
        super.removeById(id);
        afterDelete(t);
    }

    protected boolean exist(String column, Object value) {
        return exist(null, column, value);
    }

    protected boolean exist(Long id, String column, Object value) {
        return super.count(Wrappers.<T>query().eq(column, value).ne(id != null, "id", id)) > 0;
    }

    protected boolean exists(Long id, LambdaQueryWrapper<T> wrapper) {
        return super.count(wrapper.ne(id != null, T::getId, id)) > 0;
    }

    /**
     * 检查重复
     */
    protected void checkExist(T t, DTO dto) {
    }

    protected void createExtend(T t) {
    }

    protected void modifyExtend(T t) {
    }

    protected void afterCreate(T t, DTO dto) {
    }

    protected void afterModify(T t, DTO dto) {
    }

    protected void afterDelete(T t) {
    }
}
