/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import model.*;

/**
 *
 * @author mikaeil
 */
public class RestaurantService {
    
    ArrayList<Restaurant> restaurants = new ArrayList<>();

    public RestaurantService() {
        
        restaurants.add(new Restaurant(0, "MCDonald", "pass", (new Address("Eindhoven", "Streetname", 12))));
        restaurants.add(new Restaurant(1, "The Burger", "pass", (new Address("Eindhoven", "Streetname", 13))));
        restaurants.add(new Restaurant(2, "Woke", "pass", (new Address("Rotterdam", "Streetname", 13))));
        restaurants.add(new Restaurant(3, "KFC", "pass", (new Address("Rotterdam", "Streetname", 13))));
        restaurants.get(0).setMenu(new Item("BigMac",8,restaurants.get(0).getRestaurantName()));
        restaurants.get(1).setMenu(new Item("Beef Burger",12,restaurants.get(1).getRestaurantName()));
        restaurants.get(2).setMenu(new Item("Nudle",5,restaurants.get(3).getRestaurantName()));
        restaurants.get(3).setMenu(new Item("Zinger Burger",9,restaurants.get(3).getRestaurantName()));
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
    public void createRestaurant(Restaurant R){
        restaurants.add(R);
    }
    
    
}
