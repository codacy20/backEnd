/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import model.Item;
import model.User;
import service.UserService;

/**
 * REST Web Service
 *
 * @author tycho
 */
@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    Response r;
    UserService service;

    public UserResource() throws SQLException {
        service = new UserService();
    }

    @GET
    public Response getAllUsers() throws Exception {
        List<User> Users = service.getAllUsers();
        r = null;
        try {
            if (Users != null) {
                return r = Response.ok(Users).build();
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
    @Path("name/{username}")
    public Response getUserByName(@PathParam("username") String username) {
        try {
            r = null;
            User u = service.getUserByName(username);
            if (u != null) {
                u.setPassword("");
                r = Response.ok(u).build();
            } else {
                r = Response.status(Response.Status.NOT_FOUND)
                        .entity("User does not exist")
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

    @POST
    @Path("/create")
    public Response createUser(@QueryParam("username")String username,
                               @QueryParam("password")String pass,
                               @QueryParam("email")String email,
                               @QueryParam("city")String city,
                               @QueryParam("housenumber")String housenumber,
                               @QueryParam("street")String street,
                               @QueryParam("postcode")String postcode){
        
        r = null;
        
//        try {
//            if (service.createUser(username)) {
//                r = Response.ok().build();
//            } else {
//                r = Response.status(Response.Status.CONFLICT)
//                        .entity("User already exists")
//                        .build();
//            }
//        } catch (Exception e) {
//            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity(e.getMessage())
//                    .build();
//        } finally {
//            return r;
//        }
        return r = Response.ok().entity(username).build();
    }

    @PUT
    @Path("update")
    public Response updateUser(User u) {
        r = null;
        try {
            if (service.updateUser(u)) {
                r = Response.noContent().build();
            } else {
                r = Response.status(Response.Status.NOT_FOUND)
                        .entity("Username not found")
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

    @GET
    @Path("login/{username}")
    public Response login(@PathParam("username") String name, String pass) {
        r = null;
        try {
            int result = service.login(name, pass);
            switch (result) {
                case 1:
                    r = Response.ok().build();
                    break;
                case 0:
                    r = Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Password incorrect")
                            .build();
                    break;
                case -1:
                    r = Response.status(Response.Status.NOT_FOUND)
                            .entity("Username not found")
                            .build();
                    break;
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
    @Path("signup")
    public Response signup(User u) {
        r = null;
        try {
            boolean result = service.createUser(u);
            if (result) {
                r = Response.status(Response.Status.CREATED).build();
            } else {
                r = Response.status(Response.Status.CONFLICT)
                        .entity("A user with that name already exists")
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
