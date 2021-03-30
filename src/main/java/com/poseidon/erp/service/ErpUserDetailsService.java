package com.poseidon.erp.service;

import com.poseidon.erp.bean.entity.SysUser;
import com.poseidon.erp.exception.UnAuthorizedException;
import com.poseidon.erp.oauth2.ErpSysUser;
import com.poseidon.erp.utils.ResponseCode;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mario on 2020/9/21.
 */
@AllArgsConstructor
@Component
public class ErpUserDetailsService implements UserDetailsService {

    private final SysUserService userService;
    private final SysRoleService sysRoleService;
    private final SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.findByUsername(username);
        if (user == null) {
            throw new UnAuthorizedException(ResponseCode.USER_NOT_FOUND);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        sysRoleService
                .findByUserId(user.getId())
                .forEach(role -> {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getCode());
                    authorities.add(grantedAuthority);
                });

        sysPermissionService
                .findByUserId(user.getId())
                .forEach(permission -> {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
                    authorities.add(grantedAuthority);
                });

        return new ErpSysUser(user.getId(), username, user.getRealname(), user.getPassword(), authorities);
    }
}
