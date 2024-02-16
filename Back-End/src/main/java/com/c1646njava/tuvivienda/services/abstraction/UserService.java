package com.c1646njava.tuvivienda.services.abstraction;

import com.c1646njava.tuvivienda.exeptions.MyException;
import com.c1646njava.tuvivienda.models.user.User;
import com.c1646njava.tuvivienda.models.user.dto.RequestUser;
import com.c1646njava.tuvivienda.models.user.dto.ResponseUser;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public interface UserService {

    /**
     *This method is for user registration */
    void registerUser(String name, String password, String password2, String email, String country) throws MyException;
    ResponseUser registerUserResponse(RequestUser user);
    /**
     *This method log in user */
    User loginUser(String email, String password) throws AuthenticationException;
    /**
     *This method is to exit the session */
    Boolean logoutUser();
    /**
     *This method is to check the user session */
    Boolean checkSession();



}
