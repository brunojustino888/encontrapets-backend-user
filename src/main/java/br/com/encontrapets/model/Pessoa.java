package br.com.encontrapets.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "T_PESSOA")
public class Pessoa {
	
    @Id
    @Column(name = "EMAIL", nullable = false, length = 255)
    private String email;

    @Column(name = "NOME", nullable = false, length = 255)
    private String nome;

    @Column(name = "TELEFONE", length = 20)
    private String telefone;

    @Column(name = "FLAG_PHONE_VISIVEL")
    private String flagPhoneVisivel;

    @Column(name = "ID_ENDERECO")
    private Long idEndereco;
    
    @Column
    private Long idUsuario;

    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "USER_CADASTRO")
    private String userCadastro;

    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private Date dataAtualizacao;

    @Column(name = "USER_ATUALIZACAO", nullable = false)
    private String userAtualizacao;
    
    @Transient
    private String senha;

}
