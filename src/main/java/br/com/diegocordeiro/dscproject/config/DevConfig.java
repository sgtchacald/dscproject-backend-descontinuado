package br.com.diegocordeiro.dscproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.diegocordeiro.dscproject.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instatiateDatabase(){
		dbService.instantiateDevDatabase();
		return true;
	}
}
