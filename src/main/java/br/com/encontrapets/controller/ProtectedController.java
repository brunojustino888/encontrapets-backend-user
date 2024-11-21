package br.com.encontrapets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.encontrapets.dto.AlteracaoRequestDto;
import br.com.encontrapets.dto.UserDetailDto;
import br.com.encontrapets.service.UpdateUserDataService;
import br.com.encontrapets.service.UserDetailService;

/**
 * Controller responsavel por carregar e atualizar as informacoes de um determinado usuario.
 * 
 * @author Bruno Justino. 
 */
@RestController
@RequestMapping("/api/protected")
public class ProtectedController {
	
	/**
	 * Service de detalhes do usuario.
	 */
	@Autowired
    private UserDetailService uUserDetailService;
	
	/**
	 * Service de atualizacao de dados.
	 */
	@Autowired
    private UpdateUserDataService uUpdateUserDataService;

	/**
	 * Carrega as informacoes de um determinado usuario ja autenticado atraves de token jwt.
	 * 
	 * @return ResponseEntity - 200 OK em caso de sucesso.
	 */
    @GetMapping("/userDetail")
    @PreAuthorize("hasAuthority('ROLE_USER')")  
    public ResponseEntity<UserDetailDto> loadUserDetails() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    	return this.uUserDetailService.loadUserDetails(userDetails.getUsername()); 
    }

    /**
     * Atualiza os dados de um determinado usuario ja autenticado atraves de token jwt.
     * 
     * @param aAlteracaoRequestDto - AlteracaoRequestDto - dados para update.
     * @return ResponseEntity - 200 OK em caso de sucesso.
     */
    @PatchMapping("/updateUserDetails")
    @PreAuthorize("hasAuthority('ROLE_USER')")  
    public ResponseEntity<AlteracaoRequestDto> updateUserDetails(@RequestBody AlteracaoRequestDto aAlteracaoRequestDto ) {
    	return this.uUpdateUserDataService.update(aAlteracaoRequestDto); 
    }

}
