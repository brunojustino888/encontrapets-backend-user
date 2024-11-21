package br.com.encontrapets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplicacao responsavel por detalhar e alterar dados dos usuarios.
 * 
 * @author Bruno Justino.
 */
@SpringBootApplication
public class EncontrapetsBackendUserApplication {

	/**
	 * Metodo main da aplicacao rest.
	 * 
	 * @param args - String[] - parametros da jvm.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EncontrapetsBackendUserApplication.class, args);
	}

}
