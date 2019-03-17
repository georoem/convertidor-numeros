package com.devcom.convertidornumeros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** 
 * Classe principal de la aplicación
 * @author Jorge Aguirre
 * 
 */
@SpringBootApplication
public class ConvertidorNumerosApplication implements WebMvcConfigurer {

	/** Método de entrada de la aplicación
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConvertidorNumerosApplication.class, args);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
	 */
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
