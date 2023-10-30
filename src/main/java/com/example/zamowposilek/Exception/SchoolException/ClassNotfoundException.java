package com.example.zamowposilek.Exception.SchoolException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak takiej klasy")
public class ClassNotfoundException extends RuntimeException{
}
