package com.c1646njava.tuvivienda.models.user.dto;

import com.c1646njava.tuvivienda.models.image.Image;

import javax.validation.constraints.NotBlank;

public record RequestUser(@NotBlank String name,
                          @NotBlank String email,
                          @NotBlank String password,
                          Image avatar,
                          @NotBlank String country) {
}
