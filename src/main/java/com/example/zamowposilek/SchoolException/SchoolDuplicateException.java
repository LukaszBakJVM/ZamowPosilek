package com.example.zamowposilek.SchoolException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Taka szkoła już jest zapisana")
public class SchoolDuplicateException extends RuntimeException{
}
