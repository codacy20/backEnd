/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import model.User;
import service.UserService;

/**
 * REST Web Service
 *
 * @author tycho
 */
@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    Response r;
    UserService service;

    public UserResource() {
        service = new UserService();
    }

    @GET
    @Path("id/{userID}")
    public Response getUserByID(@PathParam("userID") int id) {
        try {
            r = null;
            User u = service.getUserByID(id);
            r = Response.ok(u).build();
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @GET
    @Path("username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByName(@PathParam("username") String username) {
        try {
            r = null;
            User u = service.getUserByUsername(username);
            r = Response.ok(u).build();
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }
}
