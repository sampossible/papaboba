/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ajiaa
 */
public class Order {
    public int id;
    public String name;
    public boolean closer;
    public boolean small;
    public boolean large;
    public String flavor;
    public int sweet;
    public int ice;
    public String add;
    
    public Order(){
    }
    
    public Order(int id, String name, boolean closer, boolean small, boolean large, String flavor, int sweet, int ice, String add){
        this.id = id;
        this.name = name;
        this.closer = closer;
        this.small= small;
        this.large = large;
        this.flavor = flavor;
        this.sweet = sweet;
        this.ice = ice;
        this.add = add;
    }
    
    public void setId (int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCloser(boolean closer){
        this.closer = closer;
    }
    public void setSmall(boolean small){
        this.small = small;
    }
    public void setLarge(boolean large){
        this.large = large;
    }
    public void setFlavor(String flavor){
        this.flavor = flavor;
    }
    public void setSweet(int sweet){
        this.sweet = sweet;
    }
    public void setIce(int ice){
        this.ice = ice;
    }
    public void setAdd(String add){
        this.add = add;
    }
}
