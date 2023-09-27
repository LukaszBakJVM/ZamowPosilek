package com.example.zamowposilek.SchoolException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak takiej szkoly")
public class SchoolNotfoundException extends RuntimeException {
}
