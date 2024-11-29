package br.com.encontrapets.service;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.encontrapets.dto.AlteracaoRequestDto;
import br.com.encontrapets.model.Endereco;
import br.com.encontrapets.model.Pessoa;
import br.com.encontrapets.model.Usuario;
import br.com.encontrapets.repository.EnderecoRepository;
import br.com.encontrapets.repository.PessoaRepository;
import br.com.encontrapets.repository.UsuarioRepository;

/**
 * Service responsavel por atualizar dados dos usuarios.
 * 
 * @author Bruno Justino.
 */
@Service
public class UpdateUserDataService {
	
	/**
     * JpaRepository de pessoa.
     */
    @Autowired
    private PessoaRepository cadastroRepository;
    
    /**
     * JpaRepository de usuario.
     */
    @Autowired
    private UsuarioRepository userRepository;
    
    /**
     * JpaRepository de endereco.
     */
    @Autowired
    private EnderecoRepository adressRepository;
    
    /**
     * Utilizado para alteracao dos dados de um determinado usuario.
     * 
     * @param aAlteracaoRequestDto - AlteracaoRequestDto - dto contendo os dados da alteracao.
     * @return ResponseEntity - 200 OK em caso de sucesso.
     */
    @Transactional
	public ResponseEntity<AlteracaoRequestDto> update(AlteracaoRequestDto aAlteracaoRequestDto) {
		aAlteracaoRequestDto.setBairro(aAlteracaoRequestDto.getBairro().toUpperCase()); 
		aAlteracaoRequestDto.setCidade(aAlteracaoRequestDto.getCidade().toUpperCase()); 
		aAlteracaoRequestDto.setEstado(aAlteracaoRequestDto.getEstado().toUpperCase()); 
		aAlteracaoRequestDto.setLogradouro(aAlteracaoRequestDto.getLogradouro().toUpperCase()); 
		aAlteracaoRequestDto.setNome(aAlteracaoRequestDto.getNome().toUpperCase()); 
		aAlteracaoRequestDto.setNumeroComplemento(aAlteracaoRequestDto.getNumeroComplemento().toUpperCase()); 
		aAlteracaoRequestDto.setFlagPhoneVisivel("S"); 
		Usuario uUsuario = new Usuario();
		Usuario uUsuarioBefore = this.userRepository.findByLogin(aAlteracaoRequestDto.getEmail()).get();
		BeanUtils.copyProperties(aAlteracaoRequestDto, uUsuario);
		uUsuario.setIdPerfil(uUsuarioBefore.getIdPerfil());
		uUsuario.setDataCadastro(uUsuarioBefore.getDataCadastro());
		uUsuario.setUserCadastro(uUsuarioBefore.getUserCadastro());
		uUsuario.setIdUsuario(uUsuarioBefore.getIdUsuario());
		uUsuario.setSenha(uUsuarioBefore.getSenha());
		uUsuario.setLogin(uUsuarioBefore.getLogin());
		uUsuario.setFlagBloqueio(uUsuarioBefore.getFlagBloqueio());
		uUsuario.setFlagExclusao(uUsuarioBefore.getFlagExclusao());
		uUsuario.setUserAtualizacao(uUsuarioBefore.getLogin());
		uUsuario.setDataAtualizacao(new Date());
		uUsuario = this.userRepository.save(uUsuario);
		Endereco eEndereco = new Endereco();
		BeanUtils.copyProperties(aAlteracaoRequestDto, eEndereco);
		eEndereco.setIdEndereco(this.adressRepository.findEnderecoPrincipal(uUsuario.getIdUsuario()).get().getIdEndereco());
		eEndereco.setUserAtualizacao(aAlteracaoRequestDto.getEmail());
		eEndereco.setDataCadastro(uUsuarioBefore.getDataCadastro());
		eEndereco.setUserCadastro(uUsuarioBefore.getUserCadastro());
		eEndereco.setDataAtualizacao(new Date());
		eEndereco.setIdEnderecoUsuario(uUsuario.getIdUsuario());
		eEndereco = this.adressRepository.save(eEndereco);
		Pessoa pessoaTarget = new Pessoa();
		BeanUtils.copyProperties(aAlteracaoRequestDto, pessoaTarget);
		pessoaTarget.setIdEndereco(eEndereco.getIdEndereco());
		pessoaTarget.setIdUsuario(uUsuario.getIdUsuario());
		pessoaTarget.setUserAtualizacao(aAlteracaoRequestDto.getEmail());
		pessoaTarget.setDataAtualizacao(new Date());
		pessoaTarget.setDataCadastro(uUsuarioBefore.getDataCadastro());
		pessoaTarget.setUserCadastro(uUsuarioBefore.getUserCadastro());
		this.cadastroRepository.save(pessoaTarget);
		return ResponseEntity.ok(aAlteracaoRequestDto);
	}
	
}
