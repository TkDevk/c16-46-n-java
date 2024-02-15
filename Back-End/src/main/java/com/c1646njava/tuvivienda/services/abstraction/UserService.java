package com.c1646njava.tuvivienda.services.abstraction;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Long registerUser(String name, String Password,String email);
    Boolean loginUser(String email, String Password);
    Boolean logoutUser();
    Boolean checkSession();



}
