package com.c1646njava.tuvivienda.services.abstraction;

import com.c1646njava.tuvivienda.models.post.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    Optional<List<Post>> searchByLocation(String address);

    Optional<List<Post>> searchByType(String type);
    Optional<List<Post>>searchByBedrooms(Integer bedrooms);
    Optional<List<Post>> searchByPrice(Long priceLow,Long PriceHigh);

}
