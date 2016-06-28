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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Item;
import model.User;

/**
 *
 * @author Amir
 */
public class ItemService implements Serializable{

    private List<Item> itemlist = new ArrayList<>();

    Database d;
    InputOutput io = new InputOutput();
    final static String FILE_NAME = "C:\\Users\\Administrator\\Desktop\\newItem";
    final static String FILE_NAME_Amir = "C:\\Users\\Amir\\Desktop\\newItem";


    public ItemService() throws SQLException {
        //d = new Database();
        //itemlist = d.GetAllItems("SELECT * FROM products");
        itemlist.add(new Item("Something", 20, "La Place"));
        //write();
        read();
        System.err.println("Ran the Write Item");
        
        System.err.println("Ran the Read Item");
                
    }

    public List<Item> getAllItems() {
        System.err.println("Ran the Write Item");

        return itemlist;
    }

    public Item getItem(long id) throws Exception {
        for (Item i : itemlist) {
            if (i.getID() == id) {
                return i;
            }
        }
        return null;
    }
    public Item surpriseMe(String amount) throws Exception {
        Random r= new Random();
        int am=Integer.parseInt(amount);
        int respond=r.nextInt(am);
        while(am<itemlist.get(respond).getBidPrice())
        {
             respond=r.nextInt(am);
        }
        
        for (Item i : itemlist) {
            if( i.getID()==respond){
                return i;
            }
        }
        return null;
    }

    public List<Item> Search(String name) throws Exception {
        List<Item> searched = new ArrayList<>();
        for (Item i : itemlist) {
            if (i.getName().equals(name)) {
                searched.add(i);
            }
        }
        return searched;
    }

    public List<Item> getRestaurantItems(String name) throws Exception {

        List<Item> rest = new ArrayList<>();
        for (Item i : itemlist) {
            if (i.getResteurant().equals(name)) {
                rest.add(i);
            }
        }
        return rest;
    }

    public void addItem(Item item) {
        System.err.println("created!!!!");
        item.setID(itemlist.size() + 1);
        System.err.println(itemlist.size()+1);

        itemlist.add(item);
        System.err.println(itemlist.size()+1);
        write();



    }
    
    public boolean createUser(Item u) {
        for (Item user : itemlist) {
            if (user.getID() == u.getID()) {
                return false;
            }
        }
        itemlist.add(u);
        return true;
    }

    public void updateItem(long id, Item item) {
        for (Item i : itemlist) {
            if (i.getID() == id) {
                i = item;
                return;
            }
        }
    }

    public Item removeItem(long id) {
        for (Item i : itemlist) {
            if (i.getID() == id) {
                itemlist.remove(i);
                return i;
            }
        }
        return null;
    }
    
    public List<Item> read(){
        try {
            itemlist = (List<Item>) io.deserialize(io.readSmallBinaryFile(FILE_NAME));
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void write(){
        try {
            io.writeSmallBinaryFile(io.serialize(itemlist),FILE_NAME);
            read();
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
