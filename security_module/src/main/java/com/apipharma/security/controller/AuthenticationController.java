package com.apipharma.security.controller;

import com.apipharma.security.config.JwtService;
import com.apipharma.security.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userDao;

    private final JwtService jwtUtils;  // this class generates the token

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        final UserDetails user= userDao.findUserByEmail(request.getEmail());
        if( user != null) {
            String token= jwtUtils.generateToken(user);
            System.out.println(token);
             return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(400).body("Some error has ocurred");
        }
    }








}
