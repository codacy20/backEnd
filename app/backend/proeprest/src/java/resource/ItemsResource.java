/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;
 
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Item;
import model.Restaurant;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.ItemService;

/**
 * REST Web Service
 *
 * @author Amir
 */
@Path("item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemsResource {

    Response r;
    ItemService itemService = null;

    public ItemsResource() throws SQLException {
        itemService = new ItemService();
    }

    @GET
    public Response getAllItems() throws Exception {
        List<Item> items = itemService.getAllItems();
        r = null;
        try {
            if (items != null) {
                return r = Response.ok(items).header("Access-Control-Allow-Origin", "*").build();
            } else {
                throw new Exception("Nothing exist here!");
            }
        } catch (Exception e) {
            return r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*")
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
                r = Response.ok(item).header("Access-Control-Allow-Origin", "*").build();
            } else {
                throw new Exception("Nothing exist here!");
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*")
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @GET
    @Path("rest/{restaurantName}")
    public Response getRestaurantItems(String ss) throws Exception {
        
        r = null;
        JSONParser parser=new JSONParser();
        Object obj= parser.parse(ss);
        JSONObject json = (JSONObject)obj;
        String name=(String)json.get("name");
        
        List<Item> items = itemService.getRestaurantItems(name);
        try {
            if (items != null) {
                r = Response.ok(items).header("Access-Control-Allow-Origin", "*").build();
            } else {
                throw new Exception("We dont have a list of items for that restaurant.");

            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*")
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @GET
    @Path("search/{search}")
    public Response Search(String ss) throws Exception {
        
        r = null;
        JSONParser parser=new JSONParser();
        Object obj= parser.parse(ss);
        JSONObject json = (JSONObject)obj;
        String name=(String)json.get("name");
        
        List<Item> items = itemService.Search(name);
        try {
            if (items != null) {
                r = Response.ok(items).header("Access-Control-Allow-Origin", "*").build();
            } else {
                throw new Exception("We dont have a list of items for that Search phrase.");
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*")
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @POST
    @Path("/create")
    public Response addItem(String ss) throws ParseException{
        
        r = null;
        JSONParser parser=new JSONParser();
        Object obj= parser.parse(ss);
        JSONObject json = (JSONObject)obj;
        String name=(String)json.get("name");
        String price=(String)json.get("price");
        String Restaurant=(String)json.get("restaurant");
        
        
        int pricee = Integer.parseInt(price);
        Item item = new Item(name, pricee, Restaurant);
        try {

            itemService.addItem(item);
            //itemService.createUser(item);
            r = Response.ok().header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            r = Response.status(Response.Status.FORBIDDEN).header("Access-Control-Allow-Origin", "*")
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @PUT
    @Path("update")
    public Response updateItem(String ss) throws ParseException{
        
        r = null;
        JSONParser parser=new JSONParser();
        Object obj= parser.parse(ss);
        JSONObject json = (JSONObject)obj;
        String idd=(String)json.get("id");
        String name=(String)json.get("name");
        String price=(String)json.get("price");
        String Restaurant=(String)json.get("restaurant");
        
        
        int id = Integer.parseInt(idd);
        int pricee = Integer.parseInt(price);
        Item item = new Item(name, pricee, Restaurant);
        r = null;
        try {
            itemService.updateItem(id, item);
            r = Response.ok().header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            r = Response.status(Response.Status.FORBIDDEN).header("Access-Control-Allow-Origin", "*")
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }

    }

    @DELETE
    @Path("{ItemId}")
    public Response deleteItem(String ss) throws ParseException {
        
        r = null;
        JSONParser parser=new JSONParser();
        Object obj= parser.parse(ss);
        JSONObject json = (JSONObject)obj;
        long id=(long)json.get("ItemId");
        
        
        try {
            Item i = itemService.removeItem(id);
            r = Response.ok().header("Access-Control-Allow-Origin", "*").build();
        } catch (Exception e) {
            r = Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*")
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }
    @POST
    @Path("/surpriseme")
    public Response surpriseme(String ss) throws ParseException {
        r = null;
        //r.getHeaderString();
        JSONParser parser=new JSONParser();
        Object obj= parser.parse(ss);
        JSONObject json = (JSONObject)obj;
        String amount=(String)json.get("amount");
        
        
        try {
            Item result = itemService.surpriseMe(amount);
            
            
                    r = Response.ok().header("Access-Control-Allow-Origin", "*").entity(result).build();
         
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*")
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

}
