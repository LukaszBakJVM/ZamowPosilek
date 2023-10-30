package com.example.zamowposilek.Exception.Restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Taka Restauracja już  istnieje")
public class RestaurantDuplicateException extends RuntimeException{
}
