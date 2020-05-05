package com.cts.onlinedonation.security;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cts.onlinedonation.entity.User;
import com.cts.onlinedonation.repository.UserRepository;


@Component
public class UsernamePasswordAuthFilter
        extends OncePerRequestFilter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired 
    private UserRepository userrepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
       
        

        String username = request.getHeader("username");
        String password = request.getHeader("password");
    
        if (password == null) {
            // step 1
            Authentication a = new UsernamePasswordAuthentication(username, password);
            a = authenticationManager.authenticate(a);
            // we generate an OTP
            String code = String.valueOf(new Random().nextInt(9999) + 1000);

            User passwordEntity = new User();
            passwordEntity.setUsername(username);
            passwordEntity.setPassword(code);
            userrepository.save(passwordEntity);
        } else {
            // step 2
            Authentication a = new UsernamePasswordAuthentication(username, password);
            a = authenticationManager.authenticate(a);
            // we issue a token
            response.setHeader("Authorization", UUID.randomUUID().toString());
        }
    }
   
    

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/login");
    }
}
