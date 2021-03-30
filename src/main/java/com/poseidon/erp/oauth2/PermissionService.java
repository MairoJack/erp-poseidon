package com.poseidon.erp.oauth2;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.poseidon.erp.common.Constants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collection;


/**
 * 自定义权限判断
 *
 * @author mario on 2020/9/30.
 */
@Component("pms")
public class PermissionService {
    public boolean hasPermission(String... permissions) {
        if (ArrayUtil.isEmpty(permissions)) {
            return false;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return authorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .filter(StringUtils::hasText)
                .anyMatch(x -> StrUtil.equals(x, Constants.ROLE_ADMIN) || StrUtil.equalsAny(x, permissions));
    }
}
