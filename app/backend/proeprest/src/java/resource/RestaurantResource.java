/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import model.Address;
import model.Item;
import model.Restaurant;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import service.RestaurantService;

/**
 *
 * @author mikaeil
 */
@Path("restaurant")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestaurantResource {

    Response r;
    RestaurantService service;

    public RestaurantResource() throws SQLException {
        service = new RestaurantService();
    }

    @GET
    public Response getAllRestaurants() throws Exception {
        List<Restaurant> Restaurants = service.getAllRestaurants();
        r = null;
        try {
            if (Restaurants != null) {
                return r = Response.ok(Restaurants).build();
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
    @Path("id/{restaurant_ID}")
    public Response getRestaurantByID(@PathParam("restaurant_ID") int id) {
        try {
            r = null;
            Restaurant Res = service.getRestaurantByID(id);
            r = Response.ok(Res).build();
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @GET
    @Path("restaurant_Name/{restaurant_Name}")
    public Response getRestaurantByName(@PathParam("restaurant_Name") String res_name) {
        try {
            r = null;
            Restaurant Res = service.getRestaurantByname(res_name);
            r = Response.ok(Res).build();
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @GET
    @Path("City/{City}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRestaurantByCity(@PathParam("City") String res_City) {
        try {
            r = null;
            ArrayList<Restaurant> Res = service.getRestaurantByCity(res_City);
            r = Response.ok(Res).build();
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @GET
    @Path("menu/{restaurant_Name}")
    public Response getRestaurantMenu(@PathParam("restaurant_Name") String res_name) {
        try {
            r = null;
            Restaurant Res = service.getRestaurantByname(res_name);
            r = Response.ok(Res.getMenu()).build();
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @POST
    @Path("/create")
    public Response createRestaurant(String ss) throws ParseException{
        JSONParser parser=new JSONParser();
        Object obj= parser.parse(ss);
        JSONObject json = (JSONObject)obj;
        String username=(String)json.get("username");
        String pass=(String)json.get("password");
        String email=(String)json.get("email");
        String city=(String)json.get("city");
        String housenumber=(String)json.get("housenumber");
        String street=(String)json.get("street");
        String phoneNumber=(String)json.get("phoneNumber");
        Restaurant R = new Restaurant(username, pass, new Address(city, street, housenumber), email,phoneNumber);
        r = null;
        
        try {
            if (service.createRestaurant(R)) {
                r = Response.ok().entity(R).build();
            } else {
                r = Response.status(Response.Status.CONFLICT)
                        .entity("Restaurant already exists")
                        .build();
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }
    @PUT
    @Path("update")
    public Response updateRestaurant(String ss) throws ParseException{
        
        JSONParser parser=new JSONParser();
        Object obj= parser.parse(ss);
        JSONObject json = (JSONObject)obj;
        String username=(String)json.get("username");
        String pass=(String)json.get("password");
        String email=(String)json.get("email");
        String city=(String)json.get("city");
        String housenumber=(String)json.get("housenumber");
        String street=(String)json.get("street");
        String phoneNumber=(String)json.get("phoneNumber");
        Restaurant R = new Restaurant(username, pass, new Address(city, street, housenumber), email,phoneNumber);
        r = null;
        try {
            service.updateRestaurant(R);
            r = Response.ok().build();
        } catch (Exception e) {
            r = Response.status(Response.Status.FORBIDDEN)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }

    }
    @POST
    @Path("comment/{Restaurant_Name}")
    public Response Comment(String body) throws ParseException{
        JSONParser parser=new JSONParser();
        //Restaurant R = new Restaurant(username, pass, new Address(city, street, housenumber), email);
        Object obj= parser.parse(body);
        JSONObject json = (JSONObject)obj;
        String username= (String) json.get("restaurant");
        String Comment=(String)json.get("username")+": "+(String)json.get("comment") ;
        service.addComment(Comment, username);
        

//         for (int i=0; i<jsonArray.size(); i++) {
//             image_data img = new image_data();
//
//             Object jo = jsonArray.get(i);
//
//             image_data.name = jo.name;
//             image_data.thumb = jo.thumb;
//             image_data.path = jo.path;
//
//             imageArray.add(new image_data());
//
//         }
////        r = null;
//        
//        try {
//            if (true) {
//                r = Response.ok().entity(R).build();
//            } else {
//                r = Response.status(Response.Status.CONFLICT)
//                        .entity("Restaurant already exists")
//                        .build();
//            }
//        } catch (Exception e) {
//            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity(e.getMessage())
//                    .build();
//        } finally {
//            return r;
//        }
return r;
    }

}
