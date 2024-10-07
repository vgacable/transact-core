package com.transactrule.domain;

import org.springframework.boot.SpringApplication;

public class TestDomainApplication {

    public static void main(String[] args) {
        SpringApplication.from(DomainApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
