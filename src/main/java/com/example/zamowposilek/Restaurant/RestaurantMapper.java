package com.example.zamowposilek.Restaurant;




import com.example.zamowposilek.Restaurant.RestaurantAddress.RestaurantAddress;
import org.springframework.stereotype.Service;




@Service
public class RestaurantMapper {


    Restaurant map(ResAddDto dto){
        Restaurant restaurant = new Restaurant();
        RestaurantAddress restaurantAddress = new RestaurantAddress();
        restaurant.setId(dto.getRestaurantId());
        restaurant.setRestaurantName(dto.getRestaurantName());
        restaurant.setAccount(dto.getRestaurantAccount());
        restaurantAddress.setId(dto.getAddressId());
        restaurantAddress.setCity(dto.getCity());
        restaurantAddress.setZipCode(dto.getZipCode());
        restaurantAddress.setStreet(dto.getStreet());
        restaurantAddress.setHouseNumber(dto.getHouseNumber());
        restaurant.setRestaurantAddress(restaurantAddress);
        return restaurant;
    }
    ResAddDto map (Restaurant restaurant){
        ResAddDto dto = new ResAddDto();
        dto.setRestaurantId(restaurant.getId());
        dto.setRestaurantName(restaurant.getRestaurantName());
        dto.setRestaurantAccount(restaurant.getAccount());
        dto.setAddressId(restaurant.getRestaurantAddress().getId());
        dto.setCity(restaurant.getRestaurantAddress().getCity());
        dto.setZipCode(restaurant.getRestaurantAddress().getZipCode());
        dto.setStreet(restaurant.getRestaurantAddress().getStreet());
        dto.setHouseNumber(restaurant.getRestaurantAddress().getHouseNumber());
        return dto;
    }


}



