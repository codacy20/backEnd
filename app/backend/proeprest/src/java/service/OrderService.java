/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.Database;
import database.InputOutput;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Item;
import model.Order;
import model.User;
import static service.UserService.FILE_NAME;
import service.UserService;

/**
 *
 * @author Amir
 */
public class OrderService implements Serializable{

    List<Order> orderList = new ArrayList<>();
    Database d;    
    InputOutput io = new InputOutput();
    final static String FILE_NAME = "C:\\Users\\Administrator\\Desktop\\newOrder";
    final static String FILE_NAME_Amir = "C:\\Users\\Amir\\Desktop\\newOrder";
    UserService userService = new UserService();
    
    public OrderService() throws SQLException {
        
        Order ord = new Order(2, "Tom");
        ord.AddItemToOrder(new Item("Name", 10, "Restaurant"));
        //this.d = new Database();
        //orderList = d.GetOrder("SELECT * FROM `order`");
        orderList.add(ord);
        //write();
        System.err.println("Ran the Write ORDER");
        read();
        System.err.println("Ran the Read ORDER");
    }

    public List<Order> getAllOrders() {
        
        return orderList;
    }
    public List<Order> getOrdersByRes(String username) {
        List<Order> returnorders = new ArrayList<>();
        for (Order o : orderList) {
            for(Item I : o.getOrderList()){
                if (username.equals(I.getResteurant())) {
                    returnorders.add(o);
            }
            }
            
        }
        return returnorders;
    }
    public List<Order> getOrdersByName(String username) {
        List<Order> returnorders = new ArrayList<>();
        for (Order o : orderList) {
            if (username.equals(o.getOwner())) {
                returnorders.add(o);
            }
        }
        return returnorders;
    }
    
    public String getOwner(String username) {
        for (Order o : orderList) {
            if (username.equals(o.getOwner())) {
                return o.getOwner();
            }
        }
        return "Wasn't found!";
    }

    public boolean createOrder(Order orderNew) {
//        for (Order order : orderList) {
//            if (order.getOwner().equals(orderNew.getOwner())) {
//                return false;
//            }
//        }
        orderList.add(orderNew);
        write();
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

    public boolean AddItemToOrder(String username, Item it) {
        //o.AddItemToOrder(it);
            for(Order or : orderList)
            {
                
                if(or.getOwner().equals(username))
                {
                    or.AddItemToOrder(it);
                    write();
                    return true;
                }
            }
            return false;
    }

    public boolean AddOrder(String username) {
        for (Order order : orderList) {
            if (order.getOwner() == username) {
                return false;
            }
        }
        Order ord = new Order(orderList.size()+1, username);
        orderList.add(ord);
        write();
        return true;
    }
    
    public List<Item> read(){
        try {
            orderList =  (List<Order>) io.deserialize(io.readSmallBinaryFile(FILE_NAME));
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void write(){
        try {
            io.writeSmallBinaryFile(io.serialize(orderList),FILE_NAME);
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
