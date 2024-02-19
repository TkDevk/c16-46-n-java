package com.c1646njava.tuvivienda.services;

import com.c1646njava.tuvivienda.exeptions.MyException;
import com.c1646njava.tuvivienda.models.user.User;
import com.c1646njava.tuvivienda.repositories.UserRepository;
import com.c1646njava.tuvivienda.services.implementation.UserServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userService;

    @Test
    @DisplayName("Test registering a user with valid inputs")
    void registerUser_ValidInputs_Success() throws MyException {
        //Arrange
        User user = new User();
        user.setName("Pedro");
        user.setPassword("1234A");
        user.setEmail("pascalpedro@gmail.com");
        user.setCountry("Mexico");

        //Act
        userService.registerUser("Pedro","1234A","1234A","pascalpedro@gmail.com","Mexico");

        //Assert
        verify(userRepository, times(1)).save(user);

    }

    @Test
    @DisplayName("Test registering a user with invalid email format")
    void registerUser_InvalidEmail_Failure() {
        // Test logic here
    }

    @Test
    @DisplayName("Test registering a user with email that already exist")
    void registerUser_InvalidEmail_AlreadyExist_Failure() {
        //Arrange
        User user = new User();
        user.setName("Pedro");
        user.setPassword("1234A");
        user.setEmail("pascalpedro@gmail.com");
        user.setCountry("Mexico");

        // Expected userRepository behavior
        when(userRepository.findByEmail("pedroPascal@gmail.com")).thenReturn(Optional.of(user));

        //Act and assert
        assertThrows(IllegalArgumentException.class, ()
                -> userService.registerUser("Pedro","1234A","1234A","pascalpedro@gmail.com","Mexico"));

        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("Test registering a user without a country")
    void registerUser_WithEmptyCountry_Failure() {

        //Act and assert
        assertThrows(IllegalArgumentException.class, ()
                -> userService.registerUser("","1234A","1234A","pascalpedro@gmail.com",""));

        //Assert
        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("Test registering a user without a name")
    void registerUser_WithEmptyName_Failure() {
        //Act and assert
        assertThrows(IllegalArgumentException.class, ()
                -> userService.registerUser("","1234A","1234A","pascalpedro@gmail.com","Mexico"));

        //Assert
        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("Test registering a user without a email")
    void registerUser_WithEmptyEmail_Failure() {
        //Act and assert
        assertThrows(IllegalArgumentException.class, ()
                -> userService.registerUser("Pedro","1234A","1234A","","Mexico"));

        //Assert
        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("Test registering a user without a password")
    void registerUser_WithEmptyPassword_Failure() {
        //Act and assert
        assertThrows(IllegalArgumentException.class, ()
                -> userService.registerUser("Pedro","","1234A","pascalpedro@gmail.com","Mexico"));

        //Assert
        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("Test registering a user with invalid passwords")
    void registerUser_InvalidPasswords_Failure() throws MyException {

        //Act and assert
        assertThrows(IllegalArgumentException.class, ()
                -> userService.registerUser("Pedro","123","123","pascalpedro@gmail.com","Mexico"));

        //Assert
        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("Test registering a user with mismatched passwords")
    void registerUser_MismatchedPasswords_Failure() {

        //Act and assert
        assertThrows(IllegalArgumentException.class, ()
                -> userService.registerUser("Pedro","1234A","1234","pascalpedro@gmail.com","Mexico"));

        //Assert
        verify(userRepository, never()).save(any());
    }

    //-------------------------------------------------------------------

}
