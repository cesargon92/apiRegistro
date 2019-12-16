package cl.sentra.apiRegistro.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;


@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;

	public String generateToken(String userMail) {
		Map<String, Object> headerClaims  = new HashMap<>();
		Algorithm algorithm = Algorithm.HMAC256(secret);
		JWTCreator.Builder jwtBuilder = JWT.create();
		
		jwtBuilder.withSubject(userMail);
		jwtBuilder.withIssuedAt(new Date(System.currentTimeMillis()));
		jwtBuilder.withExpiresAt(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000));
		jwtBuilder.withHeader(headerClaims);
		
		return jwtBuilder.sign(algorithm);		
	}

}