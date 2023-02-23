package br.com.diegocordeiro.dscproject.resources;

import br.com.diegocordeiro.dscproject.domain.Usuario;
import br.com.diegocordeiro.dscproject.dto.CredenciaisDTO;
import br.com.diegocordeiro.dscproject.dto.EmailDTO;
import br.com.diegocordeiro.dscproject.dto.TokenJWT;
import br.com.diegocordeiro.dscproject.security.JWTUtil;
import br.com.diegocordeiro.dscproject.security.UserSS;
import br.com.diegocordeiro.dscproject.services.AuthService;
import br.com.diegocordeiro.dscproject.services.UsuarioService;
import br.com.diegocordeiro.dscproject.services.exceptions.AuthorizationException;
import br.com.diegocordeiro.dscproject.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class AuthResource {
	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthService authService;

	@Autowired
	private AuthenticationManager manager;

	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid CredenciaisDTO credenciais, HttpServletResponse response) {
		try {
			UserSS usuario = new UserSS();

			usuario.setLogin(credenciais.getLogin());
			usuario.setSenha(credenciais.getSenha());

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getSenha());

			Authentication authentication = manager.authenticate(authenticationToken);

			String token = jwtUtil.gerarToken(usuario);

			response.addHeader("Authorization", "Bearer " + token);
			response.addHeader("access-control-expose-headers", "Authorization");

			return ResponseEntity.ok(new TokenJWT(token));
		}catch (Exception e){
			throw new AuthorizationException("Erro, login e/ou senha inválidos.");
		}
	}

	@RequestMapping(value = "/atualizar-token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS usuario = UsuarioService.authenticated();
		String token = jwtUtil.gerarToken(usuario);
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/esqueci-a-senha", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
		authService.sendNewPassword(objDto.getEmail());
		return ResponseEntity.noContent().build();
	}

}
