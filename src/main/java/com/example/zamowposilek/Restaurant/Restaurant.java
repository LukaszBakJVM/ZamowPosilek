package com.example.zamowposilek.Restaurant;

import com.example.zamowposilek.CreateSchool.School.School;
import com.example.zamowposilek.Restaurant.RestaurantAddress.RestaurantAddress;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String restaurantName;
    private String account;

    BigDecimal accountBalanceParent;
    @OneToOne
    private RestaurantAddress restaurantAddress;
    @OneToMany
    private Set<School>schools=new TreeSet<>();

}


