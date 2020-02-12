package com.senlainc.homework.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Additional implements Serializable {
    private static int count = 0;
    private String name;
    private double price;
    private int idAdditional = 0;
    private Calendar dateUse;

    public Additional(String name, double price) {
        this.name = name;
        this.price = price;
        this.idAdditional = count;
        this.dateUse = new GregorianCalendar();
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Calendar getDateUse() {
        return dateUse;
    }

    @Override
    public String toString() {
        return "| ID service=" + idAdditional +
                "| Name='" + name +
                "| price=" + price;
    }
}
