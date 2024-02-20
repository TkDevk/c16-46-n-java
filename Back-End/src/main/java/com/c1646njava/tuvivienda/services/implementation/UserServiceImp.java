package com.c1646njava.tuvivienda.services.implementation;

import com.c1646njava.tuvivienda.exeptions.MyException;
import com.c1646njava.tuvivienda.models.user.User;
import com.c1646njava.tuvivienda.models.user.dto.RequestUser;
import com.c1646njava.tuvivienda.models.user.dto.ResponseUser;
import com.c1646njava.tuvivienda.repositories.UserRepository;
import com.c1646njava.tuvivienda.services.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    @Override
    public ResponseEntity<?> registerUser(String name, String password, String password2, String email, String country) throws MyException {
        try {
            // Realizar la validación llamando a tu función validation
            validation(name, password, password2, email, country);

            // Crear un nuevo usuario
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            user.setPassword(password);

            // Guardar el usuario en la base de datos
            User savedUser = userRepository.save(user);

            // Crear un objeto ResponseUser a partir del usuario guardado
            ResponseUser responseUser = new ResponseUser(savedUser);

            return new ResponseEntity<>(responseUser, HttpStatus.CREATED);
        } catch (MyException e) {
            // Manejar la excepción específica, retorna un mensaje de error genérico al usuario
            return new ResponseEntity<>("Error al registrar el usuario", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Manejar excepciones inesperadas, retornar un mensaje genérico al usuario y registrar el error
            return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public User loginUser(String email, String password) throws AuthenticationException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("Invalid email or password"));

        // 2. Verify the password using a secure hashing algorithm
        if (!password.equals(user.getPassword())) {
            throw new AuthenticationException("Invalid email or password");
        }

        // 3. Return the authenticated user object
        return user;
    }


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
        if(userRepository.findByEmail(email)!=null){
            throw new IllegalArgumentException("The email is in use");
        }
        if(country.isBlank()){
            throw new IllegalArgumentException("The user must have a country");
        }
    }
}
