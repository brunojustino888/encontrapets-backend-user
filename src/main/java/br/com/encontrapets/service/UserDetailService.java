package br.com.encontrapets.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.encontrapets.dto.UserDetailDto;
import br.com.encontrapets.model.Endereco;
import br.com.encontrapets.model.Pessoa;
import br.com.encontrapets.repository.EnderecoRepository;
import br.com.encontrapets.repository.PessoaRepository;

@Service
public class UserDetailService {
	
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Transactional
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