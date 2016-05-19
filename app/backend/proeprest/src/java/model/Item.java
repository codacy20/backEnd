/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Amir
 */
public class Item {
    
    private long ID;
    private String Name;
    private int Price;
    //private int ProductID;
    private String Resteurant;

    
    public Item(String Name, int Price, String Restaurant) {
        this.ID = 0;
        this.Name = Name;
        this.Price = Price;
        //this.ProductID = ProductID;
        this.Resteurant = Restaurant;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }



    public int getPrice() {
        return Price;
    }

//    public int getProductID() {
//        return ProductID;
//    }

    public String getResteurant() {
        return Resteurant;
    }
    
    public void setID(long ID) {
        this.ID = ID;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

//    public void setProductID(int ProductID) {
//        this.ProductID = ProductID;
//    }

    public void setResteurant(String Resteurant) {
        this.Resteurant = Resteurant;
    }

    @Override
    public String toString() {
        return "Item{" + "Name=" + Name + ", Price=" + Price + ", Resteurant=" + Resteurant + '}';
    }
    
    
    
}
