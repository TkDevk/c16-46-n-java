package com.c1646njava.tuvivienda.services.implementation;

import com.c1646njava.tuvivienda.models.post.Post;
import com.c1646njava.tuvivienda.repositories.PostRepository;
import com.c1646njava.tuvivienda.services.abstraction.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceI implements PostService {

    private final PostRepository postrepositorio;

    public PostServiceI(PostRepository postrepositorio) {
        this.postrepositorio = postrepositorio;
    }

    @Override
    public List<Post> searchByLocation(String address) {
        List<Post> posts = postrepositorio.searchByLocation(address);
        return posts;

    }

    @Override
    public List<Post> searchByType(String type) {
        return null;
    }

    @Override
    public List<Post> searchByBedrooms(Integer bedrooms) {
        return null;
    }

    @Override
    public List<Post> searchByPrice(Long priceLow, Long PriceHigh) {
        return null;
    }
}
