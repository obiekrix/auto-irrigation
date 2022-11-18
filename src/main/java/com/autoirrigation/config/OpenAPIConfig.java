package com.autoirrigation.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI serversListConfiguration(OpenAPIProperties props) {
		Contact contact = new Contact();
		contact.name("Christian Oliver");
		contact.email("christian.oliver@andela.com");
		return new OpenAPI()
			.addServersItem(new Server().url(props.getUrl()))
			.components(new Components())
			.info(
				new Info()
					.title("Automatic Irrigation API")
					.description("Automatic Irrigation API")
					.contact(contact)
					.version("v1")
			);
	}
}
