package br.com.encontrapets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {

    @GetMapping("/userDetail")
    @PreAuthorize("hasAuthority('ROLE_USER')")  
    public String protectedEndpoint() {
        return "Você está acessando um endpoint protegido!";
    }
}