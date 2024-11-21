package br.com.encontrapets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.encontrapets.dto.UserDetailDto;
import br.com.encontrapets.service.UserDetailService;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {
	
	@Autowired
    private UserDetailService uUserDetailService;

    @GetMapping("/userDetail")
    @PreAuthorize("hasAuthority('ROLE_USER')")  
    public ResponseEntity<UserDetailDto> protectedEndpoint() {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    	
    	return this.uUserDetailService.loadUserDetails(userDetails.getUsername()); 
    	
    }

}
