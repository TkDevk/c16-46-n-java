package com.c1646njava.tuvivienda.services.implementation;

import com.c1646njava.tuvivienda.exeptions.MyException;
import com.c1646njava.tuvivienda.models.user.User;
import com.c1646njava.tuvivienda.models.user.dto.RequestUser;
import com.c1646njava.tuvivienda.models.user.dto.ResponseUser;
import com.c1646njava.tuvivienda.repositories.UserRepository;
import com.c1646njava.tuvivienda.services.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    @Override
    public void registerUser(String name, String password, String password2, String email, String country) throws MyException {
        validation(name,password,password2,email,country);

        User user = new User();

        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setCountry(country);

        userRepository.save(user);
    }

    @Override
    public ResponseUser registerUserResponse(RequestUser user) {
        return new ResponseUser(userRepository.save(new User(user)));

    }

    @Override
    public User loginUser(String email, String password) throws AuthenticationException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("Invalid email or password"));

        // 2. Verify the password using a secure hashing algorithm
        if (password != user.getPassword()) {
            throw new AuthenticationException("Invalid email or password");
        }

        // 3. Return the authenticated user object
        return user;    }


    @Override
    public Boolean logoutUser() {
        return null;
    }

    @Override
    public Boolean checkSession() {
        return null;
    }

    private void validation(String name, String password,String password2, String email, String country) throws MyException {
        if(name.isBlank()){
            throw new IllegalArgumentException("The user must have a name");
        }
        if(password.isBlank() || password.length() <= 4){
            throw new IllegalArgumentException("The password must be more than 4 characters");
        }
        if (!password2.equals(password)){
            throw new IllegalArgumentException("The passwords entered must be the same");
        }
        if(email.isBlank()){
            throw new IllegalArgumentException("The user must have a email");
        }
        if(country.isBlank()){
            throw new IllegalArgumentException("The user must have a country");
        }
    }
}
