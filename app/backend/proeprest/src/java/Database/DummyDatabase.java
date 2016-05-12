/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Item;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Amir
 */
public class DummyDatabase {
    
    private static Map<Long, Item> messages = new HashMap<>();
    //private static Map<String, Profile> profiles = new HashMap<>();

	
	public static Map<Long, Item> getItems() {
		return messages;
	}

	
    
}
