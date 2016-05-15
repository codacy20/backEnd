/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author tycho
 */
public class UserService {

    ArrayList<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(0, "Tycho", "pass", (new Address("Eindhoven", "Streetname", 12))));
        users.add(new User(1, "Tom", "pass", (new Address("Eindhoven", "Streetname", 13))));
    }

    public User getUserByID(int id) {
        for (User u : users) {
            if (id == u.getUserID()) {
                return u;
            }
        }
        return null;
    }
    
    public User getUserByUsername(String username) {
        for (User u : users) {
            if (username.equals(u.getUsername())) {
                return u;
            }
        }
        return null;
    }
    
    

}
