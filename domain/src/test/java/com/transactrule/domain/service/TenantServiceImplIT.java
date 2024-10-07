package com.transactrule.domain.service;

import com.transactrule.domain.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
public class TenantServiceImplIT {
    private final TenantService tenantService;

    public TenantServiceImplIT(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @Test
    void testCreateClientTenant() {
        // Test the createClientTenant method


    }


}
