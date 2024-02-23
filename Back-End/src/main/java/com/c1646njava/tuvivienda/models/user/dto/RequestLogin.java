package com.c1646njava.tuvivienda.models.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record RequestLogin(@NotBlank(message = "El correo electrónico es obligatorio")
                           @Email(message = "El correo electrónico debe ser válido")
                           String email,
                           @NotBlank(message = "La contraseña es obligatoria")
                           String password) {
}
