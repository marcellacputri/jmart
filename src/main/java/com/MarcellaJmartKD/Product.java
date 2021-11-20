package com.MarcellaJmartKD;

import com.MarcellaJmartKD.dbjson.Serializable;

/**
 * Write a description of class Product here.
 *
 * @author Marcella Cinninthya Putri
 * @version (27/09/2021)
 */

public class Product extends Serializable 
{
    public int accountId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public ProductCategory category;
    public double price;
    public double discount;
    public byte shipmentPlans;
 
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans){
    	this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
    
    @Override
    public String toString(){
        return "Name: " + this.name + 
                "\nWeight: " + this.weight +
                "\nconditionUsed: " + this.conditionUsed +
                "\npriceTag: " + this.price +
                "\ncategory: " + this.category +
                "\nrating: " + this.discount +
                "\nstoreId: " + this.accountId;
    }
 
}
