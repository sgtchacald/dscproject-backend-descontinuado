package br.com.diegocordeiro.dscproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {
    @Bean
    public ResourceBundleMessageSource messageSource() {
        var source = new ResourceBundleMessageSource();
        source.addBasenames("messages/validacao");
        source.addBasenames("messages/negocio");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}
