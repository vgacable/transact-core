package com.transactrule.domain.service;

import com.transactrule.domain.model.ClientTenant;
import com.transactrule.domain.model.SystemTenant;
import com.transactrule.domain.model.Tenant;
import com.transactrule.domain.model.User;
import com.transactrule.domain.repository.TenantRepository;
import com.transactrule.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TenantServiceImplTest {

    @Mock
    private TenantRepository tenantRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TenantServiceImpl tenantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateClientTenant() {
        Tenant parent = new SystemTenant("ParentTenant");
        Tenant tenant = new ClientTenant("ClientTenant", parent);

        when(tenantRepository.save(any(Tenant.class))).thenReturn(tenant);

        Tenant createdTenant = tenantService.createClientTenant("ClientTenant", parent);

        assertNotNull(createdTenant);
        //assertEquals("ClientTenant", createdTenant.getName());
        verify(tenantRepository, times(1)).save(any(Tenant.class));
    }

    @Test
    void testCreateUser() {
        Tenant tenant = new SystemTenant("Tenant");
        User user = new User("UserName", "UserLogin", tenant);

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = tenantService.createUser("UserName", "UserLogin", tenant);

        assertNotNull(createdUser);
        //assertEquals("UserName", createdUser.getName());
        //assertEquals("UserLogin", createdUser.getLogin());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testGetAllTenants() {
        Tenant tenant1 = new SystemTenant("Tenant1");
        Tenant tenant2 = new ClientTenant("Tenant2", tenant1);

        when(tenantRepository.findAll()).thenReturn(Arrays.asList(tenant1, tenant2));

        List<Tenant> tenants = tenantService.getAllTenants();

        assertNotNull(tenants);
        assertEquals(2, tenants.size());
        verify(tenantRepository, times(1)).findAll();
    }

    @Test
    void testFindUser() {
        Tenant tenant = new SystemTenant("Tenant");
        User user = new User("UserName", "UserLogin", tenant);

        when(userRepository.findByLogin("UserLogin")).thenReturn(Optional.of(user));

        Optional<User> foundUser = tenantService.findUser("UserLogin");

        assertTrue(foundUser.isPresent());
        //assertEquals("UserName", foundUser.get().getName());
        verify(userRepository, times(1)).findByLogin("UserLogin");
    }
}