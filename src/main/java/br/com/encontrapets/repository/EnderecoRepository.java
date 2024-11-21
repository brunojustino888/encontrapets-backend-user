package br.com.encontrapets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.encontrapets.model.Endereco;

/**
 * Repository de endereco.
 * 
 * @author Bruno Justino.
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
	/**
	 * Retorna um endereco de acordo com o id.
	 * 
	 * @param id - Long - identificador do endereco.
	 * @return Optional - container de endereco.
	 */
	Optional<Endereco> findById(Long id);
	
	/**
	 * Retorna um endereco de acordo com o id.
	 * 
	 * @param IdEnderecoUsuario - Long - identificador do usuario dono do endereco.
	 * @return Optional - container de endereco.
	 */
	Optional<Endereco> findByIdEnderecoUsuario(Long IdEnderecoUsuario);
	
}