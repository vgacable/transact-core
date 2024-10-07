package com.transactrule.adminui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The entry point of the Spring Boot application.
 */

@SpringBootApplication(scanBasePackages ={"com.transactrule.adminui", "com.transactrule.domain"})
@EnableJpaRepositories(basePackages = "com.transactrule.domain.repository")
@EntityScan(basePackages = "com.transactrule.domain.model")
public class Application extends SpringBootServletInitializer {

    /**
     * Runs the Spring Boot application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
