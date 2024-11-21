package br.com.encontrapets.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "T_USUARIO", schema = "encontrapetsdb")
public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(name = "ID_PERFIL")
    private Integer idPerfil;
    
    @Column(name = "FLAG_BLOQUEIO")
    private String flagBloqueio;
    
    @Column(name = "FLAG_EXCLUSAO")
    private String flagExclusao;

    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "USER_CADASTRO")
    private String userCadastro;

    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private Date dataAtualizacao;

    @Column(name = "USER_ATUALIZACAO", nullable = false)
    private String userAtualizacao;

}
