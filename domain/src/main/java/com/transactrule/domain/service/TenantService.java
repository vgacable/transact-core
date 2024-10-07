package com.transactrule.domain.service;

import com.transactrule.domain.model.Tenant;
import com.transactrule.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TenantService {
    Tenant createClientTenant(String name, Tenant parent);

    User createUser(String name,String login, Tenant tenant);
    List<Tenant> getAllTenants();
    Optional<User> findUser(String login);
}
