package br.com.encontrapets.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filtro responsavel por filtrar as requisicoes da aplicacao utilizando o provider customizado de token JWT.
 * 
 * @author Bruno Justino. 
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	/**
	 * Componente provider de configuracao de token JWT.
	 */
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * Contrutor inicializando o provider.
     * 
     * @param jwtTokenProvider - JwtTokenProvider - componente provider de configuracao de token jwt.
     */
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            if (jwtTokenProvider.validateToken(token)) {
                String username = jwtTokenProvider.getUsername(token);
                UserDetails userDetails = jwtTokenProvider.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
    
}
