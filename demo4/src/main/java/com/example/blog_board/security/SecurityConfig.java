package com.example.blog_board.security;

import com.example.blog_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login", "/singUp", "/access_denied", "/resources/**").permitAll()
                //User, Admin 접근 허용
                .antMatchers("/userAccess").hasRole("USER").antMatchers("/userAccess").hasRole("ADMIN").and().formLogin().loginPage("/login").loginProcessingUrl("/login_proc").defaultSuccessUrl("/user_access").failureUrl("/access_denied").and().csrf().disable(); //로그인창

        /**
         * 로그인 인증 처리 메소드
         * @param auth
         * @throws Exception
         */
        @Override
        public void configure (AuthenticationManagerBuilder auth) throws Exception{
            auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
        }
    }
}
