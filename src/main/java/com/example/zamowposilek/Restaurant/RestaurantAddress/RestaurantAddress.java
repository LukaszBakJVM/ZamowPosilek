package com.example.zamowposilek.Restaurant.RestaurantAddress;

import com.example.zamowposilek.Restaurant.Restaurant;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class RestaurantAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String zipCode;
    private String street;
    private String houseNumber;
    @OneToOne
    private Restaurant restaurant;

    public RestaurantAddress() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantAddress that = (RestaurantAddress) o;
        return Objects.equals(city, that.city) && Objects.equals(zipCode, that.zipCode) && Objects.equals(street, that.street) && Objects.equals(houseNumber, that.houseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, zipCode, street, houseNumber);
    }
}
