/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author mikaeil
 */
public class Restaurant {
    
    int restaurant_ID;
    String restaurant_Name;
    String password;
    Address address;
    String email;
    String phoneNumber;
    List<Item> menu;
    
    public Restaurant() {
    }

    public Restaurant(int resID, String resName, String password, Address address) {
        this.restaurant_ID = resID;
        this.restaurant_Name = resName;
        this.password = password;
        this.address = address;
        this.email = null;
        this.phoneNumber = null;
    }

    public Restaurant(int resID, String resName, String password, Address address, String email, String phoneNumber) {
        this.restaurant_ID = resID;
        this.restaurant_Name = resName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setRestaurantID(int resID) {
        this.restaurant_ID = resID;
    }

    public void setRestaurantName(String resName) {
        this.restaurant_Name = resName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setMenu(Item itemX) {
        this.menu.add(itemX);
    }

    public int getRestaurantID() {
        return restaurant_ID;
    }

    public String getRestaurantName() {
        return restaurant_Name;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public List<Item> getMenu() {
        return this.menu;
    }
    
}
