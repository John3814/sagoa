package com.udea.sagoa.dominio.user.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;
import static com.udea.sagoa.dominio.user.model.Permission.*;


public enum Role {
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_WRITE,
                    ADMIN_UPDATE,
                    ADMIN_DELETE
            )
    ),
    METER_READER(
            Set.of(
                   METER_READER_READ,
                   METER_READER_WRITE,
                   METER_READER_UPDATE
            )
    ),
    BILLING_CLERK(
            Set.of(
                    BILLING_CLERK_READ,
                    BILLING_CLERK_WRITE,
                    BILLING_CLERK_UPDATE
            )
    ),
    BILLING_ADMIN(
            Set.of(
                    BILLING_ADMIN_READ,
                    BILLING_ADMIN_WRITE,
                    BILLING_ADMIN_UPDATE
            )
    ),
    CUSTOMER_SUPPORT(
            Set.of(
                    CUSTOMER_SUPPORT_READ,
                    CUSTOMER_SUPPORT_WRITE,
                    CUSTOMER_SUPPORT_UPDATE
            )
    ),
    MAINTENANCE_OPERATOR(
            Set.of(
                    MAINTENANCE_OPERATOR_READ,
                    MAINTENANCE_OPERATOR_WRITE,
                    MAINTENANCE_OPERATOR_UPDATE
            )
    ),
    CUSTOMER(
            Set.of(
                    CUSTOMER_READ,
                    CUSTOMER_WRITE,
                    CUSTOMER_UPDATE
            )
    );


    private final Set<Permission> permissions;


    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }


    public Set<Permission> getPermissions() {
        return permissions;
    }


    public Set<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}



