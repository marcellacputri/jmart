package com.MarcellaJmartKD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.MarcellaJmartKD.dbjson.Serializable;
/**
 * Write a description of class PriceTag here.
 *
 * @author Marcella Cinninthya Putri
 * @version (25/09/2021)
 */

public class Store extends Serializable
{
    public static final String REGEX_PHONE = "^\\d{9, 12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\\1).{4,20}$";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;
    
    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
   
    @Override
    public String toString(){
        return(
            "name: " + this.name +"\n" +
            "address: " + this.address + "\n" +
            "phoneNumber: " + this.phoneNumber + "\n"
        );
    }
    
 public boolean validate()
    {
        Pattern name = Pattern.compile(REGEX_NAME);
        Matcher matcher = name.matcher(this.name);
        Pattern phone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = phone.matcher(this.phoneNumber);
        boolean nameMatcher = matcher.find();
        boolean phoneMatcher = matcherPhone.find();
        
        if(nameMatcher == true && phoneMatcher == true)
        {
            return true;
        }
        return false;
    }
       
        
}
