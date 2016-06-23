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
    @Produces(MediaType.APPLICATION_JSON)
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
    @Path("restaurant_City/{City}")
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
    @Produces(MediaType.APPLICATION_JSON)
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
    public Response createRestaurant(@QueryParam("username")String username,
                               @QueryParam("password")String pass,
                               @QueryParam("email")String email,
                               @QueryParam("city")String city,
                               @QueryParam("housenumber")String housenumber,
                               @QueryParam("street")String street){
        
        Restaurant R = new Restaurant(username, pass, new Address(city, street, housenumber), email);
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

}
