package com.transactrule.domain.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tenant_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Tenant {

    public Tenant(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    protected Long tenantId;

    @Column(nullable = false, unique = true)
    protected String name;

    @ManyToOne
    @Nullable
    protected Tenant parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<Tenant> subTenants;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<User> users;
}

