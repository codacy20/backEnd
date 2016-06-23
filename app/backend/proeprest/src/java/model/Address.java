/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author tycho
 */
public class Address implements Serializable{

    String city;
    String street;
    String housenumber;
    String addition;

    public Address() {
    }

    public Address(String city, String street, String housenumber, String addition) {
        this.city = city;
        this.street = street;
        this.housenumber = housenumber;
        this.addition = addition;
    }

    public Address(String city, String street, String housenumber) {
        this.city = city;
        this.street = street;
        this.housenumber = housenumber;
        this.addition = null;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public String getAddition() {
        return addition;
    }

}
