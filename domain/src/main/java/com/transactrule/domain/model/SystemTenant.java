package com.transactrule.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@NoArgsConstructor
@DiscriminatorValue("SYSTEM")  // Value to be stored in 'tenant_type' column for SystemTenant
public class SystemTenant extends Tenant{
    public SystemTenant(String name){
        super(name);
    }

    public SystemTenant(String name, Tenant parent){
        super(name);
        this.parent = parent;
    }
}
