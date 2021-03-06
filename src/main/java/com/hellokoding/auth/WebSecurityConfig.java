package com.hellokoding.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

   /* @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/login","/fogot-password","/newPassword/save","/reset","/search").permitAll()
                    .antMatchers("/role/**").hasAuthority("ADMIN") 
                    .antMatchers("/user/**").hasAuthority("MANAGER")
                    .antMatchers("/category/**").hasAuthority("DUAN")
                    .antMatchers("/product/nha-mua/**","/search-nhaban").hasAuthority("NHABAN")
                    .antMatchers("/product/cho-thue/**","/search-chothue").hasAuthority("NHATHUE")
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/welcome")
                    .failureUrl("/login?error")
                    .and()
                .logout()
                    .permitAll()
                    .and()
        
                   .exceptionHandling()
                   .accessDeniedPage("/403");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)/*passwordEncoder(bCryptPasswordEncoder()*/;
    }
}