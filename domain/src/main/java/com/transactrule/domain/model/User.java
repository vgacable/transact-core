package com.transactrule.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tenant_user")
@Getter
public class User {

    public User(){

    }

    @Id
    @GeneratedValue
    private Long userId;

    private String login;
    private String name;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    public User(String name, String login, Tenant tenant) {
        this.name = name;
        this.login = login;
        this.tenant = tenant;
    }
}