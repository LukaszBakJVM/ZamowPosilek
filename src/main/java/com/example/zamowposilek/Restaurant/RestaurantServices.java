package com.example.zamowposilek.Restaurant;


import com.example.zamowposilek.Exception.Restaurant.RestaurantDuplicateException;
import com.example.zamowposilek.Exception.Restaurant.RestaurantNotFoundException;
import com.example.zamowposilek.Restaurant.RestaurantAddress.RestaurantAddress;
import com.example.zamowposilek.Restaurant.RestaurantAddress.RestaurantAddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServices {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantAddressRepository restaurantAddressRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantServices(RestaurantRepository restaurantRepository,
                              RestaurantAddressRepository restaurantAddressRepository,
                              RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantAddressRepository = restaurantAddressRepository;
        this.restaurantMapper = restaurantMapper;
    }
     ResAddDto save(ResAddDto dto){
         Optional<Restaurant> byRestaurantName = restaurantRepository.findByRestaurantName(dto.getRestaurantName());
         byRestaurantName.ifPresent(p->{throw new RestaurantDuplicateException();
         });
         Restaurant map = restaurantMapper.map(dto);
         RestaurantAddress restaurantAddress = restaurantAddressRepository.save(map.getRestaurantAddress());
         restaurantAddress.setRestaurant(map);
         Restaurant save = restaurantRepository.save(map);
         return restaurantMapper.map(save);
     }
     ResAddDto findByIb(long id){
         Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(RestaurantNotFoundException::new);
         return restaurantMapper.map(restaurant);


     }
}
