package br.com.abacaxi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Value("${abacaxi.openapi.dev-url}")
	private String devUrl;

	@Value("${abacaxi.openapi.prod-url}")
	private String prodUrl;
	
	@Bean
	public OpenAPI openApiConfig() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL Dev");
		
		
		Server prodServer = new Server();
		prodServer.setUrl(prodUrl);
		prodServer.setDescription("Server URL prod");
		
		Contact contact = new Contact();
		contact.setEmail("abacaxi@gmail.com");
		contact.setName("Abacaxi Dev");
		contact.setUrl("https://www.abacaxi.com.br");
	
		License mitLicense = new License().name("MIT License").url("https://opensource.org/license/mit/");
		
		Info info = new Info()
				.title("Api Abacaxi")
				.version("1.0")
				.contact(contact)
				.description("Essa API é para gerenciar os abacaxis no estoque")
				.license(mitLicense);
				
		
		return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	}
	
	
}
