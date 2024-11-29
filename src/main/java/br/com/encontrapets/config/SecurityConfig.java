package br.com.encontrapets.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Classe responsavel por realizar as configuracoes de seguranca da aplicacao.
 * 
 * @author Bruno Justino. 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/**
	 * Provider do token JWT.
	 */
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    /**
     * Retorn o filtro Jwt com o provider configurado.
     * 
     * @return JwtAuthenticationFilter - filtro customizado para tratar as requisicoes com token jwt.
     */
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtTokenProvider);
    }
 
    /**
     * Filterchain de configuracao da aplicacao.
     * Requer autenticação para qualquer requisição.
     * Adiciona o filtro JWT antes do filtro de autenticação padrão.
     * 
     * @param http - HttpSecurity - objeto spring de de configuracoes de seguranca http.
     * @return SecurityFilterChain - cadeia de filtros de seguranca da aplicacao.
     * @throws Exception - em caso de falha.
     */
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and()
            .csrf().disable()   
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
            .and()
            .authorizeRequests()
                .anyRequest().authenticated();  
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); 
        return http.build();  
    }
}
