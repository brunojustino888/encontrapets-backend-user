package br.com.encontrapets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.encontrapets.model.Pessoa;

/**
 * Repository de pessoa.
 * 
 * @author Bruno Justino.
 */
public interface PessoaRepository extends JpaRepository<Pessoa, String> {
    
	/**
	 * Retorna uma pessoa de acordo com o email ou login.
	 * 
	 * @param email - String - login e email do usuario.
	 * @return Optional - container de pessoa.
	 */
	Optional<Pessoa> findByEmail(String email);

}