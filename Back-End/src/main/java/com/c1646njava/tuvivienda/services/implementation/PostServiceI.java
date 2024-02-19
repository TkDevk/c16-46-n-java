package com.c1646njava.tuvivienda.services.implementation;

import com.c1646njava.tuvivienda.models.post.Post;
import com.c1646njava.tuvivienda.repositories.PostRepository;
import com.c1646njava.tuvivienda.services.abstraction.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceI implements PostService {

    @Autowired
    private  PostRepository postrepositorio;



    @Override
    public Optional<List<Post>> searchByLocation(String address) {
        return postrepositorio.searchByLocation(address);

    }

    @Override
    public Optional<List<Post>> searchByType(String type) {
        return postrepositorio.searchByType(type);

    }

    @Override
    public Optional<List<Post>>  searchByBedrooms(Integer bedrooms1) {
        return postrepositorio.searchByBedrooms(bedrooms1);
    }

    @Override
    public Optional<List<Post>> searchByPrice(Long priceLow, Long PriceHigh) {
        return postrepositorio.searchByPrice(priceLow,PriceHigh);
    }

    public Long crearPost(Post post){
        postrepositorio.save(post);
        Optional<Post> posteo = postrepositorio.findById(post.getId());

        if(posteo.isEmpty()){
            return null;
        }else{
            return posteo.get().getId();
        }
    }
}
