package com.netpluspay.visa.qr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) {
        try {
            //http.requiresChannel().anyRequest().requiresSecure();
           // http.authorizeRequests().antMatchers("/").permitAll();
            http.csrf().disable();
            http.headers().httpStrictTransportSecurity()
                    .maxAgeInSeconds(0)
                    .includeSubDomains(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
