package br.com.encontrapets.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entidade de endereco.
 * 
 * @author Bruno Justino.
 */
@Data
@Entity
@Table(name = "T_ENDERECO", schema = "encontrapetsdb")
public class Endereco {
	
	/**
	 * Representa o identificador do endereco.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

	/**
	 * Representa o identificador do usuario do endereco.
	 */
    @Column
    private Long idEnderecoUsuario;
    
    /**
	 * Representa o identificador do post caso o endereco seja de um post e nao do cadastro.
	 */
    @Column
    private Long idPost;
    
	/**
	 * Representa o logradouro do endereco.
	 */
    @Column(nullable = false)
    private String logradouro;

	/**
	 * Representa o cep do endereco.
	 */
    @Column(nullable = false)
    private String cep;

	/**
	 * Representa o bairro do endereco.
	 */
    @Column
    private String bairro;
    
	/**
	 * Representa a cidade do endereco.
	 */
    @Column
    private String cidade;
    
	/**
	 * Representa o estado do endereco.
	 */
    @Column
    private String estado;
    
	/**
	 * Representa o numero e complemento.
	 */
    @Column
    private String numeroComplemento;
    
	/**
	 * Representa a data de cadastro do endereco.
	 */
    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

	/**
	 * Representa o usuario de cadastro do endereco.
	 */
    @Column(name = "USER_CADASTRO")
    private String userCadastro;

	/**
	 * Representa a data de atualizacao de cadastro do endereco.
	 */
    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private Date dataAtualizacao;

	/**
	 * Representa o usuario de atualizacao do endereco.
	 */
    @Column(name = "USER_ATUALIZACAO", nullable = false)
    private String userAtualizacao;

}
