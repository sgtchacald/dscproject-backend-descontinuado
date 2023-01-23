package br.com.diegocordeiro.dscproject.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.whith.is.user}")
    private String whithIsUser;

    public String gerarToken(UserSS usuario) {
        try {

            return JWT.create()
                    .withIssuer(whithIsUser)
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                    .sign(Algorithm.HMAC256(secret));

        } catch (JWTVerificationException e){
            throw new RuntimeException("Erro ao gerar o token jwt.", e);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer(whithIsUser)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

}