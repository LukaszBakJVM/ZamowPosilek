package com.example.zamowposilek.Restaurant;

import com.example.zamowposilek.CreateSchool.School.School;
import com.example.zamowposilek.Restaurant.RestaurantAddress.RestaurantAddress;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String restaurantName;
    private String account;

   private BigDecimal accountBalanceParent;
    @OneToOne(mappedBy = "restaurant")
    private RestaurantAddress restaurantAddress;
    @OneToMany(mappedBy = "restaurant")
    private Set<School>schools=new TreeSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getAccountBalanceParent() {
        return accountBalanceParent;
    }

    public void setAccountBalanceParent(BigDecimal accountBalanceParent) {
        this.accountBalanceParent = accountBalanceParent;
    }

    public RestaurantAddress getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(RestaurantAddress restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public Set<School> getSchools() {
        return schools;
    }

    public void setSchools(Set<School> schools) {
        this.schools = schools;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(restaurantName, that.restaurantName) && Objects.equals(restaurantAddress, that.restaurantAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantName, restaurantAddress);
    }

}


