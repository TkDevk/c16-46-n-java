package com.c1646njava.tuvivienda.services.abstraction;

import com.c1646njava.tuvivienda.models.image.ImageUser;

import java.util.Optional;

public interface ImageUserService {
    Optional<ImageUser> findAvatarByUser(Long id);
}
