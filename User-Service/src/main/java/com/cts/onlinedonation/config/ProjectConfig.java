package com.cts.onlinedonation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.cts.onlinedonation.security.UsernamePasswordAuthFilter;
import com.cts.onlinedonation.security.UsernamePasswordAuthProvider;

@Configuration@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsernamePasswordAuthProvider authProvider;

    @Autowired
    private OtpAuthenticationProvider otpAuthenticationProvider;

    @Autowired
    private TokenAuthProvider tokenAuthProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider)
            .authenticationProvider(otpAuthenticationProvider)
            .authenticationProvider(tokenAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity http) {
        http.addFilterAt(usernamePasswordAuthFilter(),
                BasicAuthenticationFilter.class)
            .addFilterAfter(tokenAuthFilter(),
                BasicAuthenticationFilter.class );
    }

    @Bean
    public TokenAuthFilter tokenAuthFilter() {
        return new TokenAuthFilter();
    }

    @Bean
    public UsernamePasswordAuthFilter usernamePasswordAuthFilter() {
        return new UsernamePasswordAuthFilter();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsernamePasswordAuthProvider authProvider;

    

    @Autowired
    private UsernamePasswordAuthFilter usernamePasswordAuthFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

   

    @Override
    protected void configure(HttpSecurity http) {
        http.addFilterAt(usernamePasswordAuthFilter,
                BasicAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
