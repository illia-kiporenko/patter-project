package me.kiporenko.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"me.kiporenko.system", "me.kiporenko.auth"})
@EnableJpaRepositories(basePackages = {
		"me.kiporenko.system.repository",
		"me.kiporenko.auth.repository"
})
@EntityScan(basePackages = {
		"me.kiporenko.system.model",
		"me.kiporenko.auth.domain.model"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
