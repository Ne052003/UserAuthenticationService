package com.neoapps.authenticationService.service;

import com.neoapps.authenticationService.model.User;
import com.neoapps.authenticationService.repository.UserServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
    private final UserServiceApi userServiceApi;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) {

        User user = userServiceApi.getUserCredentialsByEmail(emailAddress);

        return new SecurityUser(user);

    }
}
