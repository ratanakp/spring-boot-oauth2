package com.example.demooauth2.services;

import com.example.demooauth2.entities.User;
import com.example.demooauth2.entities.UserPrincipal;
import com.example.demooauth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceConfig implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = this.userRepository
                .findUserByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(
                        () -> new UsernameNotFoundException("Hey username or email not found!!!" + usernameOrEmail)
                );


        return UserPrincipal.createUser(user);
    }
}
