package br.com.encontrapets.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	 * @return List - lista de enderecos de uma pessoa.
	 */
	List<Endereco> findByIdEnderecoUsuario(Long IdEnderecoUsuario);
	
	/**
	 * Utilizado para encontrar o endereco principal do cadastro.
	 * 
	 * @return Optional - container de endereco.
	 */
	@Query("SELECT te FROM Endereco te WHERE te.idPost is null and te.idEnderecoUsuario = (:idUsuario)")
	Optional<Endereco> findEnderecoPrincipal(@Param("idUsuario") Long idUsuario);
	
}