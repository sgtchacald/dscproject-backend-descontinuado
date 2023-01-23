package br.com.diegocordeiro.dscproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DscprojectApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(DscprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
