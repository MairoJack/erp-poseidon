package com.poseidon.erp.oauth2;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author mario on 2019-09-19.
 */
@Configuration
@EnableResourceServer
@AllArgsConstructor
public class WebResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

    private final RedisConnectionFactory redisConnectionFactory;
    private final ResourceAuthExceptionEntryPoint resourceAuthExceptionEntryPoint;

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(
                        "/webjars/**",
                        "/resources/**",
                        "/doc.html",
                        "/swagger-resources/**",
                        "/v2/api-docs")
                .permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .authenticationEntryPoint(resourceAuthExceptionEntryPoint)
                .tokenStore(tokenStore());
    }
}
