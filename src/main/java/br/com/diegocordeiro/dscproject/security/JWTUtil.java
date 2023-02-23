package br.com.diegocordeiro.dscproject.security;

import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.repositories.UsuarioRepository;
import br.com.diegocordeiro.dscproject.services.UsuarioService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String gerarToken(UserSS userSS) {
        try {

            Usuario usuario = usuarioRepository.findByCredenciais(userSS.getLogin());

            return JWT.create()
                    .withIssuer(whithIsUser)
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                    .withClaim("nome", usuario.getNome())
                    .withClaim("cpf", usuario.getCpf())
                    .withClaim("email", usuario.getEmail())
                    .withClaim("login", usuario.getLogin())
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