/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
public class Cd  {
    private String name,title;
    private String ID,type,year;
    private double price;

    public Cd(String name, String title, String ID, String type, String year, double price) {
        this.name = name;
        this.title = title;
        this.ID = ID;
        this.type = type;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name = " + name + "-title = " + title + "-ID = " + ID + "-type = " + type + "-year = " + year + "-price = " + price ;
    }
    
    
    
}
