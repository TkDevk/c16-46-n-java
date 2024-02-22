package com.c1646njava.tuvivienda.controllers;

import com.c1646njava.tuvivienda.exeptions.MyException;
import com.c1646njava.tuvivienda.models.user.User;
import com.c1646njava.tuvivienda.models.user.dto.RequestUser;
import com.c1646njava.tuvivienda.models.user.dto.ResponseUser;
import com.c1646njava.tuvivienda.repositories.UserRepository;
import com.c1646njava.tuvivienda.services.implementation.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImp userServiceImp;
    private final UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RequestUser requestUser) {

            userServiceImp.validation(requestUser.name(), requestUser.email(), requestUser.password(), requestUser.password2(), requestUser.country(), requestUser.avatar());

        ResponseEntity<?> responseUser = userServiceImp.registerUser(requestUser.name(), requestUser.email(), requestUser.password(), requestUser.password2(), requestUser.country());
        return responseUser;

    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody @Valid RequestUser requestUser) throws AuthenticationException {

        User responseUser = userServiceImp.loginUser(requestUser.email(),requestUser.password());
        return new ResponseEntity<>(responseUser,HttpStatus.OK);
    }

}
