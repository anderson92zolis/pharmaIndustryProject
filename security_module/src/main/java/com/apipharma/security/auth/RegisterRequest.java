package com.apipharma.security.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
