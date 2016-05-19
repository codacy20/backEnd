/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.util.List;
import model.Item;
import service.ItemService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.User;

/**
 * REST Web Service
 *
 * @author Amir
 */
@Path("items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemsResource {

    Response r;
    ItemService itemService = new ItemService();

    @GET
    public Response getAllItem() throws Exception {
        List<Item> items = itemService.getAllItems();
        r = null;
        try {
            if (items != null) {
                return r = Response.ok(items).build();
            } else {
                throw new Exception("Nothing exist here!");
            }
        } catch (Exception e) {
            return r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("{ItemId}")
    public Response getItem(@PathParam("ItemId") long id) throws Exception {
        r = null;
        Item item = itemService.getItem(id);
        try {
            if (item != null) {
                r = Response.ok(item).build();
            } else {
                throw new Exception("Nothing exist here!");
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }
/*
    @GET
    @Path("{resteurantName}")
    public Response getResteurantItems(@PathParam("resteurantName") String name) throws Exception {
        r = null;
        List<Item> items = itemService.getResteurantItems(name);
        try {
            if (items != null) {
                r = Response.ok(items).build();
            } else {
                throw new Exception("We dont have a list of items for that resteuarant.");

            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @GET
    @Path("{search}")
    public Response Search(@PathParam("search") String name) throws Exception {
        r = null;
        List<Item> items = itemService.Search(name);
        try {
            if (items != null) {
                r = Response.ok(items).build();
            } else {
                throw new Exception("We dont have a list of items for that Search phrase.");
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }
*/
    @POST
    public Response addItem(Item item) {
        try {
            itemService.addItem(item);
            r = Response.ok(item).build();
        } catch (Exception e) {
            r = Response.status(Response.Status.FORBIDDEN)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @PUT
    @Path("{ItemId}")
    public Response updateItem(@PathParam("ItemId") long id, Item item) {
        r = null;
        try {
            itemService.updateItem(id, item);
            r = Response.ok(item).build();
        } catch (Exception e) {
            r = Response.status(Response.Status.FORBIDDEN)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }

    }

    @DELETE
    @Path("{ItemId}")
    public Response deleteItem(@PathParam("ItemId") long id) {
        r = null;
        try {
            Item i = itemService.removeItem(id);
            r = Response.ok(i).build();
        } catch (Exception e) {
            r = Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

}
