package br.com.encontrapets.service;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.encontrapets.dto.AlteracaoRequestDto;
import br.com.encontrapets.model.Endereco;
import br.com.encontrapets.model.Pessoa;
import br.com.encontrapets.model.Usuario;
import br.com.encontrapets.repository.PessoaRepository;
import br.com.encontrapets.repository.EnderecoRepository;
import br.com.encontrapets.repository.UsuarioRepository;

@Service
public class UpdateUserDataService {
	
    @Autowired
    private PessoaRepository cadastroRepository;
    
    @Autowired
    private UsuarioRepository userRepository;
    
    @Autowired
    private EnderecoRepository adressRepository;
    
    
    
    @Transactional
	public ResponseEntity<AlteracaoRequestDto> save(AlteracaoRequestDto aAlteracaoRequestDto) {

    	aAlteracaoRequestDto.setSenha(new BCryptPasswordEncoder().encode(aAlteracaoRequestDto.getSenha()));
		aAlteracaoRequestDto.setBairro(aAlteracaoRequestDto.getBairro().toUpperCase()); 
		aAlteracaoRequestDto.setCidade(aAlteracaoRequestDto.getCidade().toUpperCase()); 
		aAlteracaoRequestDto.setEstado(aAlteracaoRequestDto.getEstado().toUpperCase()); 
		aAlteracaoRequestDto.setLogradouro(aAlteracaoRequestDto.getLogradouro().toUpperCase()); 
		aAlteracaoRequestDto.setNome(aAlteracaoRequestDto.getNome().toUpperCase()); 
		aAlteracaoRequestDto.setNumeroComplemento(aAlteracaoRequestDto.getNumeroComplemento().toUpperCase()); 
		
		Usuario uUsuario = new Usuario();
		BeanUtils.copyProperties(aAlteracaoRequestDto, uUsuario);
		uUsuario.setIdPerfil(2);
		uUsuario.setLogin(aAlteracaoRequestDto.getEmail());
		uUsuario.setFlagBloqueio("N");
		uUsuario.setFlagExclusao("N");
		uUsuario.setUserCadastro("SYSTEM");
		uUsuario.setUserAtualizacao("SYSTEM");
		uUsuario.setDataAtualizacao(new Date());
		uUsuario.setDataCadastro(new Date());
		uUsuario = this.userRepository.save(uUsuario);
		
		Endereco eEndereco = new Endereco();
		BeanUtils.copyProperties(aAlteracaoRequestDto, eEndereco);
		eEndereco.setUserCadastro("SYSTEM");
		eEndereco.setUserAtualizacao("SYSTEM");
		eEndereco.setDataAtualizacao(new Date());
		eEndereco.setDataCadastro(new Date());
		eEndereco.setIdEnderecoUsuario(uUsuario.getIdUsuario());
		eEndereco = this.adressRepository.save(eEndereco);
		
		Pessoa pessoaTarget = new Pessoa();
		BeanUtils.copyProperties(aAlteracaoRequestDto, pessoaTarget);
		pessoaTarget.setIdEndereco(eEndereco.getIdEndereco());
		pessoaTarget.setIdUsuario(uUsuario.getIdUsuario());
		pessoaTarget.setUserCadastro("SYSTEM");
		pessoaTarget.setUserAtualizacao("SYSTEM");
		pessoaTarget.setDataAtualizacao(new Date());
		pessoaTarget.setDataCadastro(new Date());
		this.cadastroRepository.save(pessoaTarget);

		return ResponseEntity.status(HttpStatus.CREATED).body(aAlteracaoRequestDto);
 
	}
	
}