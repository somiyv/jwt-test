package com.example.jwttest.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring() // 아래 관련 요청은 다무시한다.
                .antMatchers("/h2-console/**"
                        , "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // httpservletrequest를 사용하는 요청들에 대한 접근 제한 설정
                .antMatchers("/api/hello").permitAll() // 이 api는 인증안받을게
                .anyRequest().authenticated(); // 나머지는 다인증받을거야
    }
}
