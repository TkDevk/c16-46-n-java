package com.c1646njava.tuvivienda.exeptions.dto.Errors;

import org.springframework.http.HttpStatus;

public class errorMessage {
    HttpStatus status;
    String message;

    public errorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
