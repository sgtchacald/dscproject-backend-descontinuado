package br.com.diegocordeiro.dscproject.config;

import br.com.diegocordeiro.dscproject.filters.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private Environment env;

	@Autowired
	private SecurityFilter securityFilter;

	private static final String[] PUBLIC_MATCHERS = {
	};

	private static final String[] PUBLIC_MATCHERS_GET = {
		"/usuarios/existe-usuario",
	};

	private static final String[] PUBLIC_MATCHERS_POST = {
		"/login",
		"/usuarios/inserir-usuario-site"
	};

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}

		http.cors().disable();

		http.csrf().disable();

		return http.authorizeRequests()
			.requestMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			.requestMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.requestMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated()
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore(this.securityFilter, UsernamePasswordAuthenticationFilter.class)
			.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
		configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
