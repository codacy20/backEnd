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

/**
 *
 * @author Amir
 */
public class OrderService implements Serializable{

    List<Order> orderList = new ArrayList<>();
    Database d;    
    InputOutput io = new InputOutput();
    final static String FILE_NAME = "C:\\Users\\Administrator\\Desktop\\newOrder";
    
    public OrderService() throws SQLException {
        
        Order ord = new Order(2, "Tom");
        ord.AddItemToOrder(new Item("Name", 10, "Restaurant"));
        //this.d = new Database();
        //orderList = d.GetOrder("SELECT * FROM `order`");
        write();
        System.err.println("Ran the Write ORDER");
        read();
        System.err.println("Ran the Read ORDER");
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

    public boolean AddItemToOrder(Order o, Item it) {
        o.AddItemToOrder(it);
//        for (Item item : getOrderByName(username)) {
//            if (order.getID() == or.getID()) {
//                order = or;
//                return true;
//            }
//        }
        return true;
    }

    public boolean AddOrder(Order ord) {
        for (Order order : orderList) {
            if (order.getID() == ord.getID()) {
                return false;
            }
        }
        orderList.add(ord);
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
            io.writeSmallBinaryFile(io.serialize(orderList),"C:\\Users\\Administrator\\Desktop\\newOrder");
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
