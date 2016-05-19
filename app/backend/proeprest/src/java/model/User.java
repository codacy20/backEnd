/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tycho
 */
public class User {

    int userID;
    String username;
    String password;
    Address address;
    String email;

    public User() {
    }

    public User(int userID, String username, String password, Address address) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = null;
    }

    public User(int userID, String username, String password, Address address, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
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

}
