package com.transactrule.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("CLIENT")
public class ClientTenant extends Tenant {

    public ClientTenant(String name, Tenant parent) {
        super(name);
        this.parent = parent;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customers;
}
