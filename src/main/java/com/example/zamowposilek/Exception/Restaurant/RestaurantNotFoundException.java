package com.example.zamowposilek.Exception.Restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Brak takiej Restauracji")
public class RestaurantNotFoundException extends RuntimeException{
}
