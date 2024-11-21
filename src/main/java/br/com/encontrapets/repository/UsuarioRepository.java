package br.com.encontrapets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.encontrapets.model.Usuario;

/**
 * Repository de usuario.
 * 
 * @author Bruno Justino.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
	/**
	 * Retorna uma pessoa de acordo com o email ou login.
	 * 
	 * @param login - String - login e email do usuario.
	 * @return Optional - container de usuario.
	 */
	Optional<Usuario> findByLogin(String login);

}