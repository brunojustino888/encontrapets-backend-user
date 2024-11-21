package br.com.encontrapets.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Classe de configuracao CORS das requisicoes.
 * 
 * @author Bruno Justino. 
 */
@Configuration
public class CorsConfig {
	
	/**
	 * Configuracoes de origens e metodos CORS.
	 * Permitidas as origens localhost e dominio encontrapets.
	 * Permite todos os cabeçalhos.
	 * Permite envio de cookies ou credenciais.
	 * Aplica a configuração para todas as rotas.
	 * 
	 * @return CorsFilter - filtro CORS customizado.
	 */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:5173");
        config.addAllowedOrigin("https://encontrapets.com.br");
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    
}
