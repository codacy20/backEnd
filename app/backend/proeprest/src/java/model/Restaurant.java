/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Address;
import model.Item;

/**
 *
 * @author mikaeil
 */
public class Restaurant implements Serializable{

    int restaurant_ID;
    String username;
    String password;
    Address address;
    String email;
    String phoneNumber;
    List<Item> menu;
    List<String> comments;
    //group can be user or restaurant
    String group="restaurant";
    

    public Restaurant() {
    }

    public Restaurant(String username, String password, Address address, String email,String phoneNumber) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phoneNumber= phoneNumber;
        comments=new ArrayList<String>();
        group="restaurant";
    }

    

    public void setRestaurantID(int resID) {
        this.restaurant_ID = resID;
    }

    public void setRestaurantName(String resName) {
        this.username = resName;
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

    public void setMenu(List<Item> itemX) {
        this.menu=itemX;
    }
    public void setMenuItem(Item itemX) {
        this.menu.add(itemX);
    }
    public int getRestaurantID() {
        return restaurant_ID;
    }

    public String getRestaurantName() {
        return username;
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
    public void addComment(String comment) {
        this.comments.add(comment);
    }

}
