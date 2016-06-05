/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.Database;
import java.util.List;
import model.*;

/**
 *
 * @author tycho
 */
public class UserService {

    static List<User> users;
    static Database db;

    static public User getUserByName(String username) {
        db = new Database();
        return db.GetUserByName(username);
    }

    static public boolean createUser(User u) {
        db = new Database();
        return db.CreateUser(u);
    }

    static public boolean updateUser(User u) {
        db = new Database();
        return db.UpdateUser(u);
    }

    static public int login(String user, String pass) {
        db = new Database();
        String checkPass = db.GetPassword(user);
        if (checkPass != null) {
            if (pass.equals(checkPass)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
}
