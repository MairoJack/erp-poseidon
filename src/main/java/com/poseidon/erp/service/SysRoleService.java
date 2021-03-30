package com.poseidon.erp.service;

import com.poseidon.erp.bean.dto.SysRoleDTO;
import com.poseidon.erp.bean.entity.SysRole;
import com.poseidon.erp.common.BaseService;
import com.poseidon.erp.dao.SysRoleDao;
import com.poseidon.erp.exception.BusinessException;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Service
 *
 * @author mario on 2020-09-30
 */
@Service
@Transactional
public class SysRoleService extends BaseService<SysRoleDao, SysRole, SysRoleDTO> {

    public SysRoleService() {
        super(SysRole.class, ResponseCode.ROLE_NOT_FOUND);
    }

    @Override
    protected void checkExist(SysRole entity, SysRoleDTO dto) {
        if (exist(entity.getId(), "name", dto.getName())) {
            throw new BusinessException(ResponseCode.ROLE_HAS_EXISTED);
        }
        if (exist(entity.getId(), "code", dto.getCode())) {
            throw new BusinessException(ResponseCode.ROLE_HAS_EXISTED);
        }
    }

    /**
     * 根据用户ID查找角色列表
     */
    public List<SysRole> findByUserId(Long userId) {
        return baseMapper.selectByUserId(userId);
    }
}
