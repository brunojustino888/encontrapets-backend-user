package br.com.encontrapets.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.encontrapets.dto.UserDetailDto;
import br.com.encontrapets.model.Endereco;
import br.com.encontrapets.model.Pessoa;
import br.com.encontrapets.repository.EnderecoRepository;
import br.com.encontrapets.repository.PessoaRepository;

/**
 * Service responsavel por detalhar dados dos usuarios.
 * 
 * @author Bruno Justino.
 */
@Service
public class UserDetailService {
	
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
     * Carrega as informacoes de um determinado usuario.
     * 
     * @param username - String - login ou email do usuario.
     * @return ResponseEntity - 200 OK em caso de sucesso.
     */
    public ResponseEntity<UserDetailDto> loadUserDetails(final String username){
    	final Optional<Pessoa> oOptionalPessoa = this.pessoaRepository.findByEmail(username);
    	if(!oOptionalPessoa.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	final Pessoa pPessoa = oOptionalPessoa.get();
    	final Endereco eEndereco = this.enderecoRepository.findById(pPessoa.getIdEndereco()).get();
    	final UserDetailDto uUserDetailDto = new UserDetailDto();
    	uUserDetailDto.setEmail(username);
    	uUserDetailDto.setFlagPhoneVisivel(pPessoa.getFlagPhoneVisivel());
    	uUserDetailDto.setNome(pPessoa.getNome());
    	uUserDetailDto.setTelefone(pPessoa.getTelefone());
    	uUserDetailDto.setBairro(eEndereco.getBairro());  
    	uUserDetailDto.setCep(eEndereco.getCep());  
    	uUserDetailDto.setCidade(eEndereco.getCidade());  
    	uUserDetailDto.setEstado(eEndereco.getEstado());  
    	uUserDetailDto.setLogradouro(eEndereco.getLogradouro());  
    	uUserDetailDto.setNumeroComplemento(eEndereco.getNumeroComplemento());  
    	return ResponseEntity.ok(uUserDetailDto);
    }
	
}