package br.com.encontrapets.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entidade de pessoa.
 * 
 * @author Bruno Justino.
 */
@Data
@Entity
@Table(name = "T_PESSOA", schema = "encontrapetsdb")
public class Pessoa {
	
	/**
	 * Representa o identificador de pesooa.
	 */
    @Id
    @Column(name = "EMAIL", nullable = false, length = 255)
    private String email;

	/**
	 * Representa o nome da pesooa.
	 */
    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

	/**
	 * Representa o telefone da pesooa.
	 */
    @Column(name = "TELEFONE", length = 20)
    private String telefone;

    /**
	 * Representa a flag de telefone visivel da pesooa.
	 */
    @Column(name = "FLAG_PHONE_VISIVEL")
    private String flagPhoneVisivel;

    /**
	 * Representa o identificador do endereco da pesooa.
	 */
    @Column(name = "ID_ENDERECO")
    private Long idEndereco;
    
    /**
	 * Representa o identificador do usuario da pesooa.
	 */
    @Column
    private Long idUsuario;

    /**
	 * Representa a data de cadastro da pesooa.
	 */
    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    /**
	 * Representa o usuario de cadastro da pesooa.
	 */
    @Column(name = "USER_CADASTRO")
    private String userCadastro;

    /**
	 * Representa a data de atualizacao da pesooa.
	 */
    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private Date dataAtualizacao;

    /**
	 * Representa o usuario de de atualizacao da pesooa.
	 */
    @Column(name = "USER_ATUALIZACAO", nullable = false)
    private String userAtualizacao;

}
