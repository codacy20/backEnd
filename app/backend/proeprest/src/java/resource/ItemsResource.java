/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import model.Item;
import service.ItemService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Amir
 */
@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemsResource {


   
    ///////////////////////
    ///////////////////////
    ///Our Code Starts Here<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    
    ItemService itemService = new ItemService();
        
    @GET
    @Path("/{ItemId}")
    public Item getMessage(@PathParam("ItemId") long id) throws Exception {
        Item item = itemService.getItem(id);
		return item;
	}	
    
    
    @POST
    public Item addMessage(Item item, @Context UriInfo uriInfo) {
		
	Item newItem = itemService.addItem(item);
    	return newItem;
    }
	
    @PUT
    @Path("/{ItemId}")
    public Item updateMessage(@PathParam("ItemId") long id, Item item) {
    	item.setID(id);
	return itemService.updateItem(item);
    }
	
    @DELETE
    @Path("/{ItemId}")
    public void deleteMessage(@PathParam("ItemId") long id) {
        itemService.removeItem(id);
    }
    
    
     ///////////////////////
    ///////////////////////
    ///THIS IS A SAMPLE DO NOT REMOVE<<< ITS FOR LEARNING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ItemsResource
     */
    public ItemsResource() {
    }

    /**
     * Retrieves representation of an instance of Resources.ItemsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ItemsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
}
