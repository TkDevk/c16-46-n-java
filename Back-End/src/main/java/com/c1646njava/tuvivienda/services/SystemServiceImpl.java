package com.c1646njava.tuvivienda.services;

import com.c1646njava.tuvivienda.models.post.Post;
import com.c1646njava.tuvivienda.services.abstraction.SystemService;

import java.util.List;

public class SystemServiceImpl implements SystemService {

    @Override
    public Long registerUser(String name, String password, String email) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Boolean loginUser(String email, String password) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Boolean logoutUser() {
        return null;
    }

    @Override
    public Boolean checkSession() {
        return null;
    }

    @Override
    public List<Post> searchByLocation(String address) {
        return null;
    }

    @Override
    public List<Post> searchByType(String type) {
        return null;
    }

    @Override
    public List<Post> searchByBedrooms(Integer bedrooms) throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<Post> searchByPrice(Long priceLow, Long priceHigh) throws IllegalArgumentException {
        return null;
    }
}
