package br.com.encontrapets.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CadastroRequestDto {

	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 2, message = "Nome deve ter no mínimo 2 caracteres.")
	private String nome;

	@NotBlank(message = "O telefone é obrigatório.")
	@Size(min = 2, message = "Telefone deve ter no mínimo 2 caracteres.")
	private String telefone;

	@NotBlank(message = "O email é obrigatório.")
	@Email(message = "O email deve ser válido.")
	private String email;

	private String flagPhoneVisivel;

	@NotBlank(message = "O logradouro é obrigatório.")
	@Size(min = 2, message = "Logradouro deve ter no mínimo 2 caracteres.")
	private String logradouro;

	@NotBlank(message = "O CEP é obrigatório.")
	@Size(min = 2, message = "CEP deve ter no mínimo 2 caracteres.")
	private String cep;

	@NotBlank(message = "O bairro é obrigatório.")
	@Size(min = 2, message = "Bairro deve ter no mínimo 2 caracteres.")
	private String bairro;

	@NotBlank(message = "O número/complemento é obrigatório.")
	@Size(min = 2, message = "Numero e complemento devem ter no mínimo 2 caracteres.")
	private String numeroComplemento;

	@NotBlank(message = "A cidade é obrigatória.")
	@Size(min = 2, message = "Cidade deve ter no mínimo 2 caracteres.")
	private String cidade;

	@NotBlank(message = "O estado é obrigatório.")
	@Size(min = 2, message = "Estado deve ter no mínimo 2 caracteres.")
	private String estado;

	@NotBlank(message = "A senha é obrigatória.")
	@Size(min = 7, message = "A senha deve ter no mínimo 7 caracteres.")
	private String senha;
	
}