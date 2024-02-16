package com.c1646njava.tuvivienda.repositories;

import com.c1646njava.tuvivienda.models.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("SELECT p FROM post p WHERE p.address =  ?1")
    public List<Post> searchByLocation(String address);
}
