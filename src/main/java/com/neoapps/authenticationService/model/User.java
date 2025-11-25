package com.neoapps.authenticationService.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String emailAddress;
    private String password;
    private Role role;
}
