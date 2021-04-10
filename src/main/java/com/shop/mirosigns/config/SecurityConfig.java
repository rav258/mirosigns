package com.shop.mirosigns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // add users
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("rafal@wp.pl").password("123").roles("EMPLOYEE"))
                .withUser(users.username("adrian").password("123").roles("MANAGER"))
                .withUser(users.username("patryk").password("123").roles("ADMIN"));
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/list*").hasAnyRole("MANAGER", "ADMIN","EMPLOYEE")
                .antMatchers("/admin/save*").hasAnyRole("MANAGER", "ADMIN","EMPLOYEE")
                .antMatchers("/admin/delete").hasRole("ADMIN")
                .antMatchers("/admin/**").hasAnyRole("EMPLOYEE", "ADMIN")
                .antMatchers("/resources/**").permitAll()
                .antMatchers("featured/list").permitAll()
                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }
}
