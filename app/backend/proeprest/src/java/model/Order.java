/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amir
 */
public class Order implements Serializable{

    private int ID;
    private String username;
    List<Item> OrderList;

    public Order() {
    }

    public Order(int ID, String username) {
        this.ID = ID;
        this.username = username;
        this.OrderList = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public String getOwner() {
        return username;
    }
//
//    public List<Item> getItemsFromOrders() {
//        return OrderList;
//    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public void setOrderList(List<Item> OrderList) {
//        this.OrderList = OrderList;
//    }
    @Override
    public String toString() {
        return "Order{" + "ID=" + ID + ", username=" + username + ", OrderList=" + OrderList + '}';
    }

    public void AddItemToOrder(Item item) {
        OrderList.add(item);
    }

}
