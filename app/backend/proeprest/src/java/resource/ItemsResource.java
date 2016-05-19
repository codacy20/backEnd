/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import model.Item;
import service.ItemService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Amir
 */
@Path("items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemsResource {

    ///////////////////////
    ///////////////////////
    ///Our Code Starts Here<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    ItemService itemService = new ItemService();

    @GET
    @Path("{ItemId}")
    public Item getItem(@PathParam("ItemId") long id) throws Exception {
        Item item = itemService.getItem(id);
        return item;
    }

    @POST
    public void addItem(Item item) {
        itemService.addItem(item);
    }

    @PUT
    @Path("{ItemId}")
    public void updateItem(@PathParam("ItemId") long id, Item item) {
        itemService.updateItem(id, item);
    }

    @DELETE
    @Path("{ItemId}")
    public void deleteItem(@PathParam("ItemId") long id) {
        itemService.removeItem(id);
    }

}
