package com.c1646njava.tuvivienda.controllers;

import com.c1646njava.tuvivienda.models.user.User;
import com.c1646njava.tuvivienda.models.user.dto.RequestUser;
import com.c1646njava.tuvivienda.repositories.UserRepository;
import com.c1646njava.tuvivienda.services.implementation.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImp userServiceImp;
    private final UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody @Valid RequestUser user){
        return new ResponseEntity<>(userServiceImp.registerUserResponse(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody RequestUser user) throws AuthenticationException {
        try {
            String email = user.email();
            String password = user.password();

            User foundUser = userRepository.findByEmail(email)
                    .orElseThrow(() -> new AuthenticationException("Email or password invalid"));

            if (password.equals(user.password())) {
                throw new AuthenticationException("Email or password invalid");

            }
            return ResponseEntity.ok().body(foundUser);


        } catch (AuthenticationException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email o contrase;a invalidos");
        }
    }

}
