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
import model.Item;

/**
 *
 * @author Amir
 */
public class ItemService {

    private List<Item> itemlist = new ArrayList<>();

    Database d;

    public ItemService() throws SQLException {
        d = new Database();

        itemlist = d.GetAllItems("SELECT * FROM products");

    }

    public List<Item> getAllItems() {

        return itemlist;
    }

//	public List<Item> getAllItemsForYear(int year) {
//		List<Item> messagesForYear = new ArrayList<>();
//		Calendar cal = Calendar.getInstance();
//		for (Item item : itemss.values()) {
//			cal.setTime(item.getCreated());
//			if (cal.get(Calendar.YEAR) == year) {
//				itemsForYear.add(item);
//			}
//		}
//		return itemsForYear;
//	}
    public Item getItem(long id) throws Exception {
        for (Item i : itemlist) {
            if (i.getID() == id) {
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
        item.setID(itemlist.size() + 1);
        itemlist.add(item);
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

}
