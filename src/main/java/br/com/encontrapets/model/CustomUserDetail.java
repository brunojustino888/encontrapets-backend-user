package br.com.encontrapets.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Model Adapter de usuario e usuario srpingboot UserDetails.
 * 
 * @author Bruno Justino.
 */
public class CustomUserDetail implements UserDetails {
 
	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Representa o usuario do encontrapets.
	 */
	private final Usuario usuario;

	/**
	 * Construtor inicializando o conteudo do objeto usuario.
	 * 
	 * @param usuario - Usuario - entidade usuario.
	 */
    public CustomUserDetail(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna as roles de acordo com o respectivo id_perfil do usuario.
     * 
     * @return - Collection - roles do usuario logado.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	if (usuario.getIdPerfil() == 1) {
            return Collections.singletonList(() -> "ROLE_ADMIN");
        } else if (usuario.getIdPerfil() == 2) {
            return Collections.singletonList(() -> "ROLE_USER");
        }
		return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPassword() {
        return this.usuario.getSenha();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return this.usuario.getLogin();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonExpired() {
    	return this.usuario.getFlagExclusao().equals("N"); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAccountNonLocked() {
    	return this.usuario.getFlagBloqueio().equals("N"); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true; 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return this.usuario.getFlagBloqueio().equals("N"); 
    }
}