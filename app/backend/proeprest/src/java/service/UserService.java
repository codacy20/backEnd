/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author tycho
 */
public class UserService {

    ArrayList<User> users = new ArrayList<>();

    public UserService() throws SQLException {
        users.add(new User("Tycho", "pass", (new Address("Eindhoven", "Streetname", 12)), "a@b.com"));
        users.add(new User("Tom", "pass", (new Address("Eindhoven", "Streetname", 13)), "a@b.com"));
    }

    public User getUserByName(String username) {
        for (User u : users) {
            if (username.equals(u.getUsername())) {
                return u;
            }
        }
        return null;
    }

    public boolean createUser(User u) {
        for (User user : users) {
            if (user.getUsername().equals(u.getUsername())) {
                return false;
            }
        }
        users.add(u);
        return true;
    }

    public boolean updateUser(User u) {
        for (User user : users) {
            if (user.getUsername().equals(u.getUsername())) {
                user = u;
                return true;
            }
        }
        return false;
    }

    public int login(String user, String pass) {
        for (User u : users) {
            if (u.getUsername().equals(user)) {
                if (u.getPassword().equals(pass)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        return -1;
    }

}
