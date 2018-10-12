package be.lookass.microservices.location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope // Can be place on a Component,Service,... Used to refresh the configuration properties file retrieve from the remote config server
@RestController
public class LocationServiceApplication {

	@Value("${message.welcome}")
	private String welcomeMessage;

	public static void main(String[] args) {
		SpringApplication.run(LocationServiceApplication.class, args);
	}

	@RequestMapping(value = "/welcome")
	public String welcomeText() {
		return welcomeMessage;
	}
}