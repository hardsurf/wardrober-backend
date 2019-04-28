package com.hardsurf.wardrober.persistence.service.impl;

import com.hardsurf.wardrober.persistence.dto.UserDto;
import com.hardsurf.wardrober.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service(value = "DB_DETAILS")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDto user = userRepository
                           .findByEmail(email)
                           .orElseThrow(() ->
                                   new UsernameNotFoundException(
                                           "User with that email address doesn't exist! <" + email + ">"
                                   )
                           );


        return new User(user.getEmail(),
                        user.getPassword(),
                        true,
                        true,
                        true,
                        true,
                        Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }

}