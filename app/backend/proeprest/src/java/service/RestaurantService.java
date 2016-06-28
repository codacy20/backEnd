/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Restaurant;
import database.Database;
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
 * @author mikaeil
 */
public class RestaurantService implements Serializable{

    ArrayList<Restaurant> restaurants = new ArrayList<>();
    Database d;    
    InputOutput io = new InputOutput();
    final static String FILE_NAME = "C:\\Users\\Administrator\\Desktop\\newRestaurant";

    public RestaurantService() throws SQLException {
        //this.d = new Database();
//        ResultSet rs= d.runQuery("Select * from restaurant");
//        while (rs.next()) { 
//            
//                //restaurants.add(new Restaurant(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),(new Address("Eindhoven", "Streetname", 12))));
//                //restaurants.add(rs.get);
//            }
       //restaurants=d.GetAllRestaurant("Select * from restaurant");
        //restaurants.add(new Restaurant(0, "la place", 1));
        //write();
        read();
        System.err.println("Ran the Read Rest");
    }

    public List<Restaurant> getAllRestaurants() {
        System.err.println("Ran the Write Resr");

        return restaurants;
    }
    public Restaurant getRestaurantByID(int id) {
        for (Restaurant R : restaurants) {
            if (id==R.getRestaurantID()) {
                return R;
            }
        }
        return null;
    }

    public Restaurant getRestaurantByname(String res_name) {
        for (Restaurant R : restaurants) {
            if (res_name.equals(R.getRestaurantName())) {
                return R;
            }
        }
        return null;
    }

    public List<Item> getRestaurantMenu(String res_name) {
        for (Restaurant R : restaurants) {
            if (res_name.equals(R.getRestaurantName())) {
                return R.getMenu();
            }
        }
        return null;
    }
    public Boolean setRestaurantMenu(String res_name, List<Item> itemX) {
        for (Restaurant R : restaurants) {
            if (res_name.equals(R.getRestaurantName())) {
                 R.setMenu(itemX);
            }
        }
        return null;
    }
    public Boolean setRestaurantMenuItem(String res_name, Item itemX) {
        for (Restaurant R : restaurants) {
            if (res_name.equals(R.getRestaurantName())) {
                 R.setMenuItem(itemX);
            }
        }
        return null;
    }

    public ArrayList<Restaurant> getRestaurantByCity(String res_city) {
        ArrayList<Restaurant> return_res = new ArrayList<>();
        for (Restaurant R : restaurants) {
            if (res_city.equals(R.getAddress().getCity())) {
                return_res.add(R);
            }
        }
        if (!return_res.isEmpty()) {
            return return_res;
        }
        return null;
    }

    public boolean createRestaurant(Restaurant R) {
        //restaurants.add(R);
        for (Restaurant res : restaurants) {
            if (res.getRestaurantName().equals(R.getRestaurantName())) {
                return false;
            }
        }
        System.err.println("created!!!!");
        R.setRestaurantID(restaurants.size() + 1);
        System.err.println(restaurants.size()+1);

        restaurants.add(R);
        System.err.println(restaurants.size()+1);
        write();
        return true;
    }
    
     public int login(String user, String pass) {
        for (Restaurant R : restaurants) {
            if (R.getRestaurantName().equals(user)) {
                if (R.getPassword().equals(pass)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        return -1;
    }
    
    public boolean addComment(String comment, String resName) {
        
        System.err.println("CM added");
        for (Restaurant R : restaurants) {
            if (resName.equals(R.getRestaurantName())) {
                R.addComment(comment);
                write();
                return true;
            }
        }
        return false;
    }
    
    public boolean updateRestaurant(Restaurant R) {
        for (Restaurant r : restaurants) {
            if (r.getRestaurantName().equals(R.getRestaurantName())) {
                r = R;
                write();
                return true;
            }
        }
        return false;
    }

    
    public List<Item> read(){
        try {
            restaurants = (ArrayList<Restaurant>) io.deserialize(io.readSmallBinaryFile(FILE_NAME));
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void write(){
        try {
            io.writeSmallBinaryFile(io.serialize(restaurants),FILE_NAME);
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
