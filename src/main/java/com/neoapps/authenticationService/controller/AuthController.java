package com.neoapps.authenticationService.controller;

import com.neoapps.authenticationService.controller.dtos.DtoAuthRequest;
import com.neoapps.authenticationService.controller.dtos.UpdateUserLastLoginRequest;
import com.neoapps.authenticationService.repository.UserServiceApi;
import com.neoapps.authenticationService.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final UserServiceApi userServiceApi;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/newToken")
    public Map<String, String> getToken(@RequestBody DtoAuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        UpdateUserLastLoginRequest updateUserLastLoginRequest = new UpdateUserLastLoginRequest(request.username(), LocalDateTime.now());
        userServiceApi.updateUserLastLogin(updateUserLastLoginRequest);

        String jwt = jwtService.generateToken(authentication);
        return Map.of("token", jwt);
    }

}
