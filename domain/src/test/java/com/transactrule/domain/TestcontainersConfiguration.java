package com.transactrule.domain;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.utility.DockerImageName;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

import java.util.List;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

    private static final String SA_PASSWORD = "YourStrong!Passw0rd";  // Set a strong password for the sa user

    @Bean
    @ServiceConnection
    MSSQLServerContainer<?> sqlServerContainer() {
        // Create a SQL Server container
        MSSQLServerContainer<?> container = new MSSQLServerContainer<>(DockerImageName.parse("mcr.microsoft.com/mssql/server:latest"))
                .acceptLicense()  // Accept the SQL Server license agreement
                .withPassword(SA_PASSWORD)  // Set the SA password
                .withExposedPorts(1433);  // Expose the default SQL Server port

        // Optionally map container port 1433 to host port 1433
        container.setPortBindings(List.of("1433:1433"));

        return container;
    }
}
