package com.c1646njava.tuvivienda.repositories;

import com.c1646njava.tuvivienda.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
