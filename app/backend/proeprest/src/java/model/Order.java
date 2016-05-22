/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amir
 */
public class Order {
    
    private int ID;
    private User Owner;
    List<Item> OrderList;

    public Order(int ID, User Owner) {
        this.ID = ID;
        this.Owner = Owner;
        this.OrderList = new ArrayList<Item>();
    }

    public int getID() {
        return ID;
    }

    public User getOwner() {
        return Owner;
    }

    public List<Item> getOrderList() {
        return OrderList;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setOwner(User Owner) {
        this.Owner = Owner;
    }

//    public void setOrderList(List<Item> OrderList) {
//        this.OrderList = OrderList;
//    }

    @Override
    public String toString() {
        return "Order{" + "ID=" + ID + ", Owner=" + Owner + ", OrderList=" + OrderList + '}';
    }
    
    public void AddItemOderList(Item item)
    {
        OrderList.add(item);
    }
    
}
