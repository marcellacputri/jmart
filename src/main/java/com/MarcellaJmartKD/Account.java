package com.MarcellaJmartKD;

/**
 * Write a description of class Account here.
 * 
 * @author Marcella Cinninthya Putri
 * @version (25/09/2021)
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.MarcellaJmartKD.dbjson.Serializable;

public class Account extends Serializable 
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&_~]+(\\.[a-zA-Z0-9&_~]+)@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)$";
    public static final String REGEX_PASSWORD = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
	public Store store;
    public String name;
    public String email;
    public String password;
    public double balance;

    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
	
    @Override
    public String toString(){
        return(
            "name: " + this.name +"\n" +
            "email: " + this.email + "\n" +
            "password: " + this.password + "\n"
        );
    }
    
     public boolean validate() {
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher emailMatcher = emailPattern.matcher(this.email);
        Pattern sandiPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher sandiMatcher = sandiPattern.matcher(this.password);
        boolean sandiMatch = sandiMatcher.find();
        boolean emailMatch = emailMatcher.find();
        
        if(sandiMatch == true && emailMatch == true) {
            return true;
        }
        return false;
    }
}

