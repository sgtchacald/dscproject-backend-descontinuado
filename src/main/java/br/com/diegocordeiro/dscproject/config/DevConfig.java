package br.com.diegocordeiro.dscproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.diegocordeiro.dscproject.services.DBService;
import br.com.diegocordeiro.dscproject.services.EmailService;
import br.com.diegocordeiro.dscproject.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;
	
	@Bean
	public boolean instatiateDatabase(){
		if(!"create-drop".equals(strategy)){
			return false;
		}
		
		dbService.instantiateDevDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
