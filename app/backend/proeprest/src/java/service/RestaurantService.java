/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author mikaeil
 */
public class RestaurantService {

    ArrayList<Restaurant> restaurants = new ArrayList<>();
    Database d;    

    public RestaurantService() throws SQLException {
        this.d = new Database();
//        ResultSet rs= d.runQuery("Select * from restaurant");
//        while (rs.next()) { 
//            
//                //restaurants.add(new Restaurant(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),(new Address("Eindhoven", "Streetname", 12))));
//                //restaurants.add(rs.get);
//            }
       restaurants=d.GetAllRestaurant("Select * from restaurant");
    }

    public Restaurant getRestaurantByID(int id) {
        for (Restaurant R : restaurants) {
            if (id == R.getRestaurantID()) {
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

    public void createRestaurant(Restaurant R) {
        restaurants.add(R);
    }

}
