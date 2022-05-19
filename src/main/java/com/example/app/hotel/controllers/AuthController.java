package com.example.app.hotel.controllers;

import com.example.app.hotel.models.AuthRequest;
import com.example.app.hotel.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println("tr " + authRequest);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid credential");
        }
        String token = jwtUtil.generateToken(authRequest.getUsername());
        Map<Object, Object> model = new HashMap<>();
        model.put("token", token);
        return ResponseEntity.ok(model);
    }
}
