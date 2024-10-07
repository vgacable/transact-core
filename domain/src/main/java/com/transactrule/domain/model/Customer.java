package com.transactrule.domain.model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;
}
