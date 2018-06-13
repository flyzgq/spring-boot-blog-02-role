package com.fly.springboot.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author fly
 * @date 2018/5/16 23:41
 * @description     安全配置类
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*/css/*", /js/**, /fonts/**,/index 都可以访问*/
        http.authorizeRequests()
            .antMatchers("/css/*", "/js/**", "/fonts/**","/index").permitAll();
    }
}
