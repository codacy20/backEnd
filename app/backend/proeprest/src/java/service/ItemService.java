/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.DummyDatabase;
import model.Item;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Amir
 */
public class ItemService {

    private final List<Item> itemlist = new ArrayList<>();

    public ItemService() {
        itemlist.add(new Item("item1", 0, "notkfc"));
        itemlist.add(new Item("item2", 0, "kfc"));
        itemlist.get(0).setID(0);
        itemlist.get(1).setID(1);
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
    
    public List<Item> getResteurantItems(String name) throws Exception {
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
