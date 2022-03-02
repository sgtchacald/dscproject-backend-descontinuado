package br.com.diegocordeiro.dscproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {
	@Bean
	public boolean instatiateDatabase(){
		return true;
	}
}