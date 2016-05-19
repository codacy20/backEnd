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
        itemlist.add(new Item("item 1", 0, "Resteurant"));
        itemlist.add(new Item("item 2", 0, "Resteurant"));
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

    public void removeItem(long id) {
        for (Item i : itemlist) {
            if (i.getID() == id) {
                itemlist.remove(i);
                return;
            }
        }
    }

}
