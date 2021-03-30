package com.poseidon.erp.oauth2;

import com.poseidon.erp.utils.Assert;
import com.poseidon.erp.utils.ResponseCode;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author mario on 2020/9/22.
 */
@UtilityClass
public class SecurityHolder {
    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public ErpSysUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof ErpSysUser) {
            return (ErpSysUser) principal;
        }
        return null;
    }

    /**
     * 获取用户
     */
    public ErpSysUser getUser() {
        Authentication authentication = Assert.notFound(getAuthentication(), ResponseCode.USER_NOT_FOUND);
        return getUser(authentication);
    }

    /**
     * 获取用户名
     */
    public String getUsername() {
        Authentication authentication = Assert.notFound(getAuthentication(), ResponseCode.USER_NOT_FOUND);
        return getUser(authentication).getUsername();
    }

    /**
     * 获取姓名
     */
    public String getRealname() {
        Authentication authentication = Assert.notFound(getAuthentication(), ResponseCode.USER_NOT_FOUND);
        return getUser(authentication).getRealname();
    }

}
