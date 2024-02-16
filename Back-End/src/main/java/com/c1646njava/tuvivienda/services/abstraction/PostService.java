package com.c1646njava.tuvivienda.services.abstraction;

import com.c1646njava.tuvivienda.models.post.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    List<Post> searchByLocation(String address);

    List<Post> searchByType(String type);
    List<Post> searchByBedrooms(Integer bedrooms);
    List<Post> searchByPrice(Long priceLow,Long PriceHigh);

}
