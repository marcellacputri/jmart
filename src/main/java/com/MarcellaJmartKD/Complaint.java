package com.MarcellaJmartKD;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.MarcellaJmartKD.dbjson.Serializable;

/**
 * Write a description of class Complaint here.
 *
 * @author (Marcella Cinninthya Putri)
 * @version (27/09/2021)
 */


    public class Complaint extends Serializable {
        public Date date;
        public String desc;

        public Complaint(String desc){
            this.date = new Date();
            this.desc = desc;
            System.out.println (date);
        }

        @Override
        public String toString() {
            return ("Complaint{date=" + new SimpleDateFormat("dd/MM/yyyy").format(date) + ", desc='" + desc + "'}");
        }
    }