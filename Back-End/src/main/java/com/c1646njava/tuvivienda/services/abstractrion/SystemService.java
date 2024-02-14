package com.c1646njava.tuvivienda.services.abstractrion;

import java.util.List;

import com.c1646njava.tuvivienda.models.post.Post;

public interface SystemService {
    
    Long registerUser(String name, String Password,String email);
    Boolean loginUser(String email, String Password);
    Boolean logoutUser();
    Boolean checkSession();
    List<Post> searchByLocation(String address);
    List<Post> searchByType(String type);
    List<Post> searchByBedrooms(Integer bedrooms);
    List<Post> searchByPrice(Long priceLow,Long PriceHigh);
     


}
