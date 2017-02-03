package com.retailstore.model;

/**
 * Created by pix-el on 02/02/2017.
 */
public class Pricing {

    private String id;
    private double list;
    private double retail;

    public Pricing(double list, double retail) {
        super();
        this.list = list;
        this.retail = retail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getList() {
        return list;
    }

    public void setList(double list) {
        this.list = list;
    }

    public double getRetail() {
        return retail;
    }

    public void setRetail(double retail) {
        this.retail = retail;
    }
}
