package com.c1646njava.tuvivienda.models.user.dto;

import com.c1646njava.tuvivienda.models.image.Image;
import com.c1646njava.tuvivienda.models.user.User;

public record ResponseUser(Long id,
                           String name,
                           String email,
                           String password,
                           Image avatar,
                           String country) {
    public ResponseUser(User user){
        this(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getAvatar(),
                user.getCountry());
    }

}

