package com.transactrule.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MSSQLServerContainer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class DomainApplicationIT {

    @Autowired
    private DataSource dataSource;  // DataSource to be used for testing the connection

    @Autowired
    private MSSQLServerContainer<?> sqlServerContainer;

    @Test
    void contextLoads() {
        // Default test to check if the Spring context loads properly
    }

    @Test
    void printConnectionDetails() {
        String host = sqlServerContainer.getHost();
        Integer port = sqlServerContainer.getMappedPort(1433);  // Get the mapped port for 1433
        String jdbcUrl = sqlServerContainer.getJdbcUrl();
        String username = sqlServerContainer.getUsername();
        String password = sqlServerContainer.getPassword();

        System.out.println("JDBC URL: " + jdbcUrl);
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
    @Test
    void testDatabaseConnection() throws Exception {
        // Use the DataSource to get a connection to the database
        try (Connection connection = dataSource.getConnection()) {
            // Create a simple query to test the connection
            try (Statement statement = connection.createStatement()) {
                // Execute a query, e.g., getting the current date from SQL Server
                ResultSet resultSet = statement.executeQuery("SELECT 1");

                // Assert that the query returns a result
                if (resultSet.next()) {
                    int result = resultSet.getInt(1);
                    System.out.println("Database connection test successful, query result: " + result);
                } else {
                    throw new IllegalStateException("Database connection test failed, no result returned.");
                }
            }
        }
    }
}

