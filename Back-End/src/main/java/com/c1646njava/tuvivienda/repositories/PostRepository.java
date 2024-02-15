package com.c1646njava.tuvivienda.repositories;

import com.c1646njava.tuvivienda.models.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
