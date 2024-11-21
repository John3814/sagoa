package com.udea.sagoa.dominio.user.dto;

import com.udea.sagoa.dominio.user.model.Role;

public record UserResgistrationData(
        String userName,
        String password,
        Role role
) {
}
