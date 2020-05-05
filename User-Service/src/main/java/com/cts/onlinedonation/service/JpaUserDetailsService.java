package com.cts.onlinedonation.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.onlinedonation.entity.User;
import com.cts.onlinedonation.repository.UserRepository;
import com.cts.onlinedonation.security.SecurityUser;



@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> o = userRepository.findUserByUsername(username);
        User u = o.orElseThrow(() -> new UsernameNotFoundException(":("));
        return new SecurityUser(u);
    }
}
