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
@Table(name = "T_ENDERECO")
public class Endereco {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @Column
    private Long idEnderecoUsuario;
    
    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String cep;

    @Column
    private String bairro;
    
    @Column
    private String cidade;
    
    @Column
    private String estado;
    
    @Column
    private String numeroComplemento;
    
    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "USER_CADASTRO")
    private String userCadastro;

    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private Date dataAtualizacao;

    @Column(name = "USER_ATUALIZACAO", nullable = false)
    private String userAtualizacao;

}
