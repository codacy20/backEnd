/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.lang.annotation.Annotation;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import model.Address;
import model.Item;
import model.User;
import org.glassfish.jersey.server.JSONP;
import service.UserService;
import org.json.simple.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
                               @QueryParam("street")String street){

        User u = new User(username, pass, new Address(city, street, housenumber), email);
        r = null;
        
        try {
            if (service.createUser(u)) {
                r = Response.ok().entity(u).build();
            } else {
                r = Response.status(Response.Status.CONFLICT)
                        .entity("User already exists")
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
    public Response updateUser(@QueryParam("username")String username,
                               @QueryParam("password")String pass,
                               @QueryParam("email")String email,
                               @QueryParam("city")String city,
                               @QueryParam("housenumber")String housenumber,
                               @QueryParam("street")String street){
        
        User u = new User(username, pass, new Address(city, street, housenumber), email);
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

    @POST
    @Path("login/")
    public Response login(String ss) throws ParseException {
        r = null;
        JSONParser parser=new JSONParser();
        Object obj= parser.parse(ss);
        JSONObject json = (JSONObject)obj;
        String username=(String)json.get("username");
        String passs;
        passs = (String)json.get("password");
        
        try {
            int result = service.login(username, passs);
            switch (result) {
                case 1:
                    User u = service.getUserByName(username);
                    r = Response.ok().header("Access-Control-Allow-Origin", "*").entity(u).build();
                    break;
                case 0:
                    r = Response.status(Response.Status.UNAUTHORIZED).header("Access-Control-Allow-Origin", "*")
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
            r = Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "*")
                    .entity(e.getMessage())
                    .build();
        } finally {
            return r;
        }
    }
    @POST
    @Path("/signup")
    public Response createUser(String u) {
        
        r = null;
        r = Response.ok().build();
//        try {
//            if (service.createUser(u)) {
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
        return r = Response.ok().entity(u).build();
    }


}
