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
@Consumes(MediaType.APPLICATION_JSON)
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
            if (u != null) {
                r = Response.ok(u).build();
            } else {
                throw new Exception("User does not exist");
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
    @Path("username/{username}")
    public Response getUserByName(@PathParam("username") String username) {
        try {
            r = null;
            User u = service.getUserByUsername(username);
            if (u != null) {
                r = Response.ok(u).build();
            } else {
                throw new Exception("User does not exist");
            }
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @POST
    @Path("{userID}")
    public Response createUser(User u) {
        r = null;
        try {
            service.createUser(u);
            r = Response.noContent().build();
        } catch (Exception e) {
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }

    @PUT
    @Path("{userID}")
    public Response updateUser(@PathParam("userID") int id, User u) {
        r = null;
        try {
            service.updateUser(id, u);
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
