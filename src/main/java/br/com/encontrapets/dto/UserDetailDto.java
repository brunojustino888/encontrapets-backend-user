package br.com.encontrapets.dto;

import lombok.Data;

/**
 * Dto de detalhes de um determinado usuario.
 * 
 * @author Bruno Justino.
 */
@Data
public class UserDetailDto {

	/**
	 * Campo do nome.
	 */
	private String nome;

	/**
	 * Campo do telefone.
	 */
	private String telefone;

	/**
	 * Campo do email e login.
	 */
	private String email;

	/**
	 * Campo da flag de telefone visivel.
	 */
	private String flagPhoneVisivel;

	/**
	 * Campo do logradouro do endereco.
	 */
	private String logradouro;

	/**
	 * Campo do cep do endereco.
	 */
	private String cep;

	/**
	 * Campo do bairro do endereco.
	 */
	private String bairro;

	/**
	 * Campo do numero e complemento do endereco.
	 */
	private String numeroComplemento;

	/**
	 * Campo cidade do endereco.
	 */
	private String cidade;

	/**
	 * Campo do estado do endereco.
	 */
	private String estado;
	
}
