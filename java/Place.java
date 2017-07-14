package com.example.pro.test1;

/**
 * Created by pro on 2017/5/6.
 */

public class Place {
    public String name = "";
    public String type = "";
    public String location = "";
    public int image;
    public Boolean isvisited = false;
    public String phone = "";
    public String introduction = "";
    public String city = "";
    public double[] weight = new double[9];

    public Place(String name,String type,String location,int image,Boolean isvisited,String phone, String city, double...weight) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.image = image;
        this.isvisited = isvisited;
        this.phone = phone;
        this.city = city;
        for(int i = 0; i<9 ; i++)
        {
            this.weight[i] = weight[i];
        }
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getIntroduction() {
        return introduction;
    }
}
