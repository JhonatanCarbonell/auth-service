package com.sena.auth_service.controller;

import com.sena.auth_service.dto.CredencialesDTO;
import com.sena.auth_service.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registro")
    public ResponseEntity<String> registrar(
            @RequestBody CredencialesDTO datos) {

        return ResponseEntity
                .status(201)
                .body(authService.registrar(datos));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody CredencialesDTO datos) {

        String respuesta =
                authService.login(datos);

        if (respuesta.equals(
                "Autenticación satisfactoria")) {

            return ResponseEntity.ok(respuesta);
        }

        return ResponseEntity
                .status(401)
                .body(respuesta);
    }
}