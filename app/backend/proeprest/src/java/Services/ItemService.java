/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Database.DummyDatabase;
import Exceptions.DataNotFoundException;
import Model.Item;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Amir
 */
public class ItemService {
    	private Map<Long, Item> itemss = DummyDatabase.getItems();
	
	public ItemService() {
		itemss.put(1L, new Item(1,"item 1",0, "Resteurant"));
		itemss.put(2L, new Item(2, "item 2", 0, "Resteurant"));
	}
	
	public List<Item> getAllMessages() {
		return new ArrayList<Item>(itemss.values()); 
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
	
	public List<Item> getAllMessagesPaginated(int start, int size) {
		ArrayList<Item> list = new ArrayList<Item>(itemss.values());
		if (start + size > list.size()) return new ArrayList<Item>();
		return list.subList(start, start + size); 
	}
	
	
	public Item getItem(long id) {
		Item item = itemss.get(id);
		if (item == null) {
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return item;
	}
	
	public Item addItem(Item item) {
		item.setID(itemss.size() + 1);
		itemss.put(item.getID(), item);
		return item;
	}
	
	public Item updateItem(Item item) {
		if (item.getID() <= 0) {
			return null;
		}
		itemss.put(item.getID(), item);
		return item;
	}
	
	public Item removeItem(long id) {
		return itemss.remove(id);
	}
	

}
