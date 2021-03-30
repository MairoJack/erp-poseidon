package com.poseidon.erp.oauth2;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 自定义用户
 *
 * @author mario on 2019-07-29.
 */
public class ErpSysUser extends User {
    private static final long serialVersionUID = 2527069378149355618L;
    @Getter
    private final Long id;
    @Getter
    private final String realname;

    public ErpSysUser(Long id, String username, String realname, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.realname = realname;
    }
}
