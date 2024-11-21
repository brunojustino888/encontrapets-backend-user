package br.com.encontrapets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Dto de alteracao de um determinado usuario.
 * 
 * @author Bruno Justino.
 */
@Data
public class AlteracaoRequestDto {

	/**
	 * Campo do nome.
	 */
	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, message = "Nome deve ter no mínimo 2 caracteres.")
	private String nome;

	/**
	 * Campo do telefone.
	 */
	@NotBlank(message = "O telefone é obrigatório.")
	@Size(min = 2, message = "Telefone deve ter no mínimo 2 caracteres.")
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
	@NotBlank(message = "O logradouro é obrigatório.")
	@Size(min = 2, message = "Logradouro deve ter no mínimo 2 caracteres.")
	private String logradouro;

	/**
	 * Campo do cep do endereco.
	 */
	@NotBlank(message = "O CEP é obrigatório.")
	@Size(min = 2, message = "CEP deve ter no mínimo 2 caracteres.")
	private String cep;

	/**
	 * Campo do bairro do endereco.
	 */
	@NotBlank(message = "O bairro é obrigatório.")
	@Size(min = 2, message = "Bairro deve ter no mínimo 2 caracteres.")
	private String bairro;

	/**
	 * Campo do numero e complemento do endereco.
	 */
	@NotBlank(message = "O número/complemento é obrigatório.")
	@Size(min = 2, message = "Numero e complemento devem ter no mínimo 2 caracteres.")
	private String numeroComplemento;

	/**
	 * Campo cidade do endereco.
	 */
	@NotBlank(message = "A cidade é obrigatória.")
	@Size(min = 2, message = "Cidade deve ter no mínimo 2 caracteres.")
	private String cidade;

	/**
	 * Campo do estado do endereco.
	 */
	@NotBlank(message = "O estado é obrigatório.")
	@Size(min = 2, message = "Estado deve ter no mínimo 2 caracteres.")
	private String estado;
	
}