package br.com.encontrapets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.encontrapets.model.Pessoa;

public interface CadastroRepository extends JpaRepository<Pessoa, String> {
    
	Optional<Pessoa> findByEmail(String email);

}