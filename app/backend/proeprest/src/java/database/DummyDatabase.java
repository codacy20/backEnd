/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.MySQLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Version;
import model.Address;
import model.Restaurant;

/**
 *
 * @author Amir
 */
public class DummyDatabase {

    Connection c;
    Statement st;
    Statement st2;
    ResultSet rs;
    ResultSet rs2;

    public static void main(String[] args) throws SQLException {
        DummyDatabase d = new DummyDatabase();
    }

    public DummyDatabase() throws SQLException {
        try {
            

               DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            c = DriverManager.getConnection("jdbc:mysql://192.168.15.56/dbi271837?", 
                    "dbi271837", 
                    "O3JUJwTWhi");
            st = c.createStatement();
            rs = st.executeQuery("SELECT user_name from users");
            while (rs.next()) {
                
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (c != null) {
                    c.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }

    }
    public ArrayList GetAllRestaurant(String myQuery)throws SQLException{
        ArrayList<Restaurant> querry=new ArrayList<>();
        try {

            c = DriverManager.getConnection("jdbc:mysql://192.168.15.56/dbi271837?", 
                    "dbi271837", 
                    "O3JUJwTWhi");
            st = c.createStatement();
            st2=c.createStatement();
            rs = st.executeQuery(myQuery);
            while(rs.next())
            {
                
                int restaurant_ID=Integer.parseInt(rs.getString(1));
                String restaurant_Name=rs.getString(2);
                String password=rs.getString(3);
                int addressID=Integer.parseInt(rs.getString(4));
                //inner querry
                rs2=st2.executeQuery("SELECT * FROM address WHERE Address_ID = '"+addressID+"' ");
                rs2.next();
                String city=rs2.getString(2);
                String street=rs2.getString(3);
                int houseNumber=Integer.parseInt(rs2.getString(4));
                String addition=rs2.getString(5);
                Address address= new Address(city,street,houseNumber,addition);
                //end of inner query
                String email=rs.getString(5);
                String phoneNumber=rs.getString(6);
                System.out.print(restaurant_Name);
                querry.add(new Restaurant(restaurant_ID,restaurant_Name,password,email,phoneNumber,address));
                
            }
            
        } finally {
            try {
                
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (c != null) {
                    c.close();
                }
                if (rs2 != null) {
                    rs2.close();
                }
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
            
     return querry;   
    }   
    
}
