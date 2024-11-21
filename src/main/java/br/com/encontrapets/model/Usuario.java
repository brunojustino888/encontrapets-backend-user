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
 * Entidade de usuario.
 * 
 * @author Bruno Justino.
 */
@Data
@Entity
@Table(name = "T_USUARIO", schema = "encontrapetsdb")
public class Usuario {
	
	/**
	 * Representa o identificador do usuario.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

	/**
	 * Representa o login e email do usuario.
	 */
    @Column(name = "LOGIN")
    private String login;

	/**
	 * Representa o campo senha do usuario.
	 */
    @Column(name = "SENHA")
    private String senha;

	/**
	 * Representa o identificador do perfil do usuario.
	 */
    @Column(name = "ID_PERFIL")
    private Integer idPerfil;
    
	/**
	 * Representa o identificador de bloqueio do usuario.
	 */
    @Column(name = "FLAG_BLOQUEIO")
    private String flagBloqueio;
    
	/**
	 * Representa o identificador de exclusao de registro do usuario.
	 */
    @Column(name = "FLAG_EXCLUSAO")
    private String flagExclusao;

	/**
	 * Representa a data de cadastro do usuario.
	 */
    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    /**
	 * Representa o usuario de cadastro.
	 */
    @Column(name = "USER_CADASTRO")
    private String userCadastro;

    /**
	 * Representa a data de atualizacao do registro.
	 */
    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private Date dataAtualizacao;

    /**
	 * Representa o usuario de atualizacao.
	 */
    @Column(name = "USER_ATUALIZACAO", nullable = false)
    private String userAtualizacao;

}
