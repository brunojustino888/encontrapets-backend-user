package br.com.encontrapets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.encontrapets.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
	Optional<Endereco> findById(Long id);
	
}