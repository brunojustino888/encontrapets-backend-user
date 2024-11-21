package br.com.encontrapets.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetail implements UserDetails {
 
	private static final long serialVersionUID = 1L;
	
	private final Usuario usuario;

    public CustomUserDetail(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	if (usuario.getIdPerfil() == 1) {
            return Collections.singletonList(() -> "ROLE_ADMIN");
        } else if (usuario.getIdPerfil() == 2) {
            return Collections.singletonList(() -> "ROLE_USER");
        }
		return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return this.usuario.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
    	return this.usuario.getFlagExclusao().equals("N"); 
    }

    @Override
    public boolean isAccountNonLocked() {
    	return this.usuario.getFlagBloqueio().equals("N"); 
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; 
    }

    @Override
    public boolean isEnabled() {
        return this.usuario.getFlagBloqueio().equals("N"); 
    }
}