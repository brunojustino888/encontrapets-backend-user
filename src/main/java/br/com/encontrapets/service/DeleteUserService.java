package br.com.encontrapets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.encontrapets.model.Endereco;
import br.com.encontrapets.model.Pessoa;
import br.com.encontrapets.model.Usuario;
import br.com.encontrapets.repository.EnderecoRepository;
import br.com.encontrapets.repository.PessoaRepository;
import br.com.encontrapets.repository.UsuarioRepository;

/**
 * Service responsavel por apagar todos dados do usuario.
 * 
 * @author Bruno Justino.
 */
@Service
public class DeleteUserService {
	
	/**
     * JpaRepository de endereco.
     */
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    /**
     * JpaRepository de pessoa.
     */
    @Autowired
    private PessoaRepository pessoaRepository;
    
    /**
     * JpaRepository de usuario.
     */
    @Autowired
    private UsuarioRepository userRepository;
    
    /**
     * Apaga todo cadastro de um determinado usuario.
     * 
     * @param username - String - login ou email do usuario.
     * @return ResponseEntity - 204 NO CONTENT em caso de sucesso.
     */
    @Transactional
    public ResponseEntity<HttpStatus> delete(final String username){
    	final Pessoa pessoa = this.pessoaRepository.findByEmail(username).get();  
    	final Endereco eEndereco = this.enderecoRepository.findById(pessoa.getIdEndereco()).get();
    	final Usuario uUsuario = this.userRepository.findById(pessoa.getIdUsuario()).get();
    	this.enderecoRepository.delete(eEndereco);
    	this.pessoaRepository.delete(pessoa);
    	this.userRepository.delete(uUsuario);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
	
}