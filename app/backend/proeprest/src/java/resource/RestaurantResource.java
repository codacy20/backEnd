/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import model.Restaurant;
import model.Restaurant;
import service.RestaurantService;
import model.User;
import service.UserService;

/**
 *
 * @author mikaeil
 */
@Path("restaurant")
@Produces(MediaType.APPLICATION_JSON)
public class RestaurantResource {

    Response r;
    RestaurantService service;

    public RestaurantResource() throws SQLException  {
        service = new RestaurantService();
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
    public Response createRestaurant(Restaurant Res) {
        r = null;
        try {
            service.createRestaurant(Res);
            r = Response.noContent().build();
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

}
