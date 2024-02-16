package com.c1646njava.tuvivienda.services.implementation;

import com.c1646njava.tuvivienda.models.post.Post;
import com.c1646njava.tuvivienda.repositories.PostRepository;
import com.c1646njava.tuvivienda.services.abstraction.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceI implements PostService {

    private final PostRepository postrepositorio;

    public PostServiceI(PostRepository postrepositorio) {
        this.postrepositorio = postrepositorio;
    }

    @Override
    public Optional<List<Post>> searchByLocation(String address) {
        return postrepositorio.searchByLocation(address);

    }

    @Override
    public Optional<List<Post>> searchByType(String type) {
        return postrepositorio.searchByType(type);

    }

    @Override
    public Optional<List<Post>> searchByBedrooms(Integer bedrooms) {
        return postrepositorio.searchByBedrooms(bedrooms);
    }

    @Override
    public Optional<List<Post>> searchByPrice(Long priceLow, Long PriceHigh) {
        return postrepositorio.searchByPrice(priceLow,PriceHigh);
    }

    /*
    public Optional<List<Post>> poraddress2(String address){
        return postrepositorio.findByAddress(address);

    }
    */

}
