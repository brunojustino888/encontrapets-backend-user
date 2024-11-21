package br.com.encontrapets.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.encontrapets.model.CustomUserDetail;
import br.com.encontrapets.model.Usuario;
import br.com.encontrapets.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Componente provider de configuracao de token JWT.
 * 
 * @author Bruno Justino. 
 */
@Component
public class JwtTokenProvider {

	/**
	 * Jwt secre key configurada no arquivo application.properties da aplicacao.
	 */
	@Value("${jwt.secret}")
	private String SECRET_KEY;

	/**
	 * Tempo de validade do token JWT.
	 * 1 hora de validade.
	 */
	private static final long VALIDITY = 1000 * 60 * 60; 

	/**
	 * JpaRepository de usuario.
	 */
	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Responsavel por gerar token JWT.
	 * 
	 * @param username - String - nome do usuario.
	 * @return String - token jwt.
	 */
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + VALIDITY))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	/**
	 * Responsavel por validar o token JWT.
	 * 
	 * @param token - String - token para validar.
	 * @return true - em caso de token valido.
	 */
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Metodo para extrair o nome de usuario do token.
	 * 
	 * @param token - String - token de autenticacao.
	 * @return String - nome do usuario do token.
	 */
	public String getUsername(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}


	/**
	 * Metodo para carregar o usuario pelo email e login.
	 * Aqui a logica para buscar o usuario no banco de dados.
	 * 
	 * @param username - String - login e email do usuario.
	 * @return UserDetails - interface spring que representa o usuario.
	 * @throws UsernameNotFoundException - Exception de not found.
	 */
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByLogin(username).get();
		return new CustomUserDetail(usuario);
	}
	
}
