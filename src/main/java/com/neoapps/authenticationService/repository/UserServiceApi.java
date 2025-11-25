package com.neoapps.authenticationService.repository;

import com.neoapps.authenticationService.controller.dtos.UpdateUserLastLoginRequest;
import com.neoapps.authenticationService.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserServiceApi {

    private final RestClient restClient;

    public UserServiceApi(RestClient restClient) {
        this.restClient = restClient;
    }

    public User getUserCredentialsByEmail(String emailAddress) {
        return restClient.get()
                .uri("/credentials/{emailAddress}", emailAddress)
                .retrieve()
                .body(User.class);
    }

    public void updateUserLastLogin(UpdateUserLastLoginRequest request) {
        restClient.put()
                .uri("/logins")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

}
