package com.example.zamowposilek.Restaurant;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long>  {
    Optional<Restaurant>findByRestaurantName(String name);

}
