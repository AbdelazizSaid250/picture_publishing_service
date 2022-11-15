package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("user"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/auth_user/signup").hasRole("USER")
                .antMatchers("/auth_user/logout").hasRole("USER")
                .antMatchers("/image/upload_picture").hasRole("USER")
                .antMatchers("/image/accepted_pictures").hasRole("ADMIN")
                .antMatchers("/image/unprocessed_pictures").hasRole("ADMIN")
                .antMatchers("/image/remove_picture").hasRole("ADMIN")
                .antMatchers("/image/accept_picture/{pictureID}").hasRole("ADMIN")
                .antMatchers("/welcome").permitAll()
                .and()
                .formLogin()
                .and()
                .logout().logoutUrl("/auth_user/logout");
    }
}
