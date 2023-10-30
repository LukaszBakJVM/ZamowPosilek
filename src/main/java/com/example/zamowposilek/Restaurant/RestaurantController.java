package com.example.zamowposilek.Restaurant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantServices restaurantServices;

    public RestaurantController(RestaurantServices restaurantServices) {
        this.restaurantServices = restaurantServices;
    }
    @PostMapping
    ResponseEntity<ResAddDto>save(@RequestBody ResAddDto resAddDto){
        ResAddDto resAdd = restaurantServices.save(resAddDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(resAdd.getRestaurantId()).toUri();
        return ResponseEntity.created(uri).body(resAdd);
    }
    @GetMapping("/{id}")
    ResponseEntity<ResAddDto>findById(@PathVariable long id){
    return ResponseEntity .ok(restaurantServices.findByIb(id));

    }
}
