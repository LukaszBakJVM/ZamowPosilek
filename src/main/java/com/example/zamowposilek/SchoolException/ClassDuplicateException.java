package com.example.zamowposilek.SchoolException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Taka klasa już  istnieje")
public class ClassDuplicateException extends RuntimeException{
}
