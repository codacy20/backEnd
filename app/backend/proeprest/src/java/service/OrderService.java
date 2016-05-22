/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import model.Address;
import model.Item;
import model.Order;
import model.User;

/**
 *
 * @author Amir
 */
public class OrderService {
    
    ArrayList<Order> orderList = new ArrayList<>();
    Order ord = new Order(2, new User());
    
    public OrderService() {
        orderList.add(new Order(0, new User()));
        orderList.add(new Order(1, new User()));
        orderList.add(ord);
    }

    public User getOrderByName(String username) {
        for (Order u : orderList) {
            if (username.equals(u.getOwner().getUsername())) {
                return u.getOwner();
            }
        }
        return null;
    }

    public boolean createOrder(Order orderNew) {
        for (Order order : orderList) {
            if (order.getOwner().equals(orderNew.getOwner())) {
                return false;
            }
        }
        orderList.add(orderNew);
        return true;
    }

    public boolean updateOrder(Order or) {
        for (Order order : orderList) {
            if (order.getID() == or.getID()) {
                order = or;
                return true;
            }
        }
        return false;
    }

    public boolean AddItemOrder(Item it){    
        ord.AddItemOderList(it);
//        for (Item item : getOrderByName(username)) {
//            if (order.getID() == or.getID()) {
//                order = or;
//                return true;
//            }
//        }
        return true;
    }
    
    public boolean AddOrder(Order ord){
    for (Order order : orderList) {
            if (order.getID() == ord.getID()) {
                return false;
            }
        }
        orderList.add(ord);
        return true;
    }
}
