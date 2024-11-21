package br.com.encontrapets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.encontrapets.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
	Optional<Usuario> findByLogin(String login);

}