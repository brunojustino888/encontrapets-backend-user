package br.com.encontrapets.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.encontrapets.model.CustomUserDetail;
import br.com.encontrapets.model.Usuario;
import br.com.encontrapets.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

	@Value("${jwt.secret}")
    private String SECRET_KEY;
	
    private final long VALIDITY = 1000 * 60 * 60; // 1 hora de validade

    @Autowired
    private UserDetailsService userDetailsService; // Injetando o UserDetailsService
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para gerar um token JWT
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + VALIDITY))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Método para validar o token JWT
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Método para obter o nome de usuário do token
    public String getUsername(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    // Método para carregar o usuário pelo nome de usuário
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aqui a lógica para buscar o usuário no banco de dados.
    	this.usuarioRepository.findByLogin(username);
    	Usuario usuario = this.usuarioRepository.findByLogin(username).get();
		return new CustomUserDetail(usuario);
    }
}