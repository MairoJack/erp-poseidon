package com.poseidon.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author mario on 2020/9/21.
 */
@MapperScan("com.poseidon.erp.dao")
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ErpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
    }
}
