package com.transactrule.domain.service;

import com.transactrule.domain.model.ClientTenant;
import com.transactrule.domain.model.Tenant;
import com.transactrule.domain.model.User;
import com.transactrule.domain.repository.TenantRepository;
import com.transactrule.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantServiceImpl implements TenantService {
    private final TenantRepository tenantRepository;
    private final UserRepository userRepository;

    public TenantServiceImpl(TenantRepository tenantRepository, UserRepository userRepository) {
        this.tenantRepository = tenantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Tenant createClientTenant(String name, Tenant parent) {
        Tenant tenant = new ClientTenant(name, parent);
        return tenantRepository.save(tenant);
    }

    @Override
    public User createUser(String name, String login, Tenant tenant) {
        User user = new User(name, login, tenant);

        return userRepository.save(user);
    }

    @Override
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    @Override
    public Optional<User> findUser(String login) {
        return userRepository.findByLogin(login);
    }

}
