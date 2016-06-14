/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.InputOutput;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import static service.ItemService.FILE_NAME;

/**
 *
 * @author tycho
 */
public class UserService implements Serializable{

    ArrayList<User> users = new ArrayList<>();
    InputOutput io = new InputOutput();
    final static String FILE_NAME = "C:\\Users\\Amir\\Desktop\\newUser";

    public UserService() throws SQLException {
        users.add(new User("Tycho", "pass", (new Address("Eindhoven", "Streetname", 12)), "a@b.com"));
        users.add(new User("Tom", "pass", (new Address("Eindhoven", "Streetname", 13)), "a@b.com"));
        write();
        System.err.println("Ran the Write");
        read();
        System.err.println("Ran the Read");
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
    
    public List<Item> read(){
        try {
            users = (ArrayList<User>) io.deserialize(io.readSmallBinaryFile(FILE_NAME));
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void write(){
        try {
            io.writeSmallBinaryFile(io.serialize(users),"C:\\Users\\Amir\\Desktop\\newUser");
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
