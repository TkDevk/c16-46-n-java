package com.c1646njava.tuvivienda.services.abstraction;

import com.c1646njava.tuvivienda.models.image.ImageUser;
import com.c1646njava.tuvivienda.models.user.User;

import java.util.Optional;

public interface ImageUserService {
    Optional<ImageUser> findAvatarByUser(Long id);

    Optional<User> addAvatarToUser(Long id, ImageUser image);

    Boolean exists(Long id);
}
