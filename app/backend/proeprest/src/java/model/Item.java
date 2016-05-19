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
    
    private int ID;
    private String Name;
    private int Price;
    private int bidPrice;
    //private int ProductID;
    private String Resteurant;

    
    public Item(String Name, int Price, String Restaurant) {
        this.ID = 0;
        this.Name = Name;
        this.Price = Price;
        this.bidPrice=bidPrice;
        //this.ProductID = ProductID;
        this.Resteurant = Resteurant;
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
    public int getBidPrice() {
        return bidPrice;
    }

//    public int getProductID() {
//        return ProductID;
//    }

    public String getResteurant() {
        return Resteurant;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
    public void setBidPrice(int Price) {
        this.Price = bidPrice;
    }

//    public void setProductID(int ProductID) {
//        this.ProductID = ProductID;
//    }

    public void setResteurant(String Resteurant) {
        this.Resteurant = Resteurant;
    }

    @Override
    public String toString() {
        return "Item{" + "Name=" + Name + ", Price=" + Price + ", bidPrice=" + bidPrice +'}';
    }  
    
    
}
