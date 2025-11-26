package com.neoapps.authenticationService.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserLastLoginRequest {
    private String email;
    private LocalDateTime lastLogin;
}
