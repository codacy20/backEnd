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
 * @author mikaeil
 */
public class RestaurantService {
    
    ArrayList<Restaurant> restaurants = new ArrayList<>();

    public RestaurantService() {
        
        restaurants.add(new Restaurant(0, "MCDonald", "pass", (new Address("Eindhoven", "Streetname", 12))));
        restaurants.add(new Restaurant(1, "KFC", "pass", (new Address("Eindhoven", "Streetname", 13))));
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
    
    public void createRestaurant(Restaurant R){
        restaurants.add(R);
    }
    
    
}
