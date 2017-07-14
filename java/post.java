package com.example.pro.test1;

public class post {
    public int id;
    public Time time;
    public String title;
    public String summary;
    public String Content;
    public User author;
    public String categary;
    public post(Time t,String title,String summary,String categary,User author) {
        this.time = t; this.title = title; this.summary = summary;
        this.categary = categary; this.author = author;
    }
    public post(Time t,String title,String summary,String categary) {
        this.time = t; this.title = title;
        this.categary = categary; this.summary = summary;
    }
    public post(String title,String summary,String categary) {
        this.title = title;
        this.categary = categary;
        this.summary = summary;
    }
    public void setId(int number) {
        this.id = number;
    }
    public void setTime(int day,int month,int year) {
        time = new Time(day,month,year);
    }
}
