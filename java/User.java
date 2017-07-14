package com.example.pro.test1;

/**
 * Created by pro on 2017/5/10.
 */

public class User {
    public String name;
    public String password;
    public String account;
    public String signature;
    public String introduction;
    public int id;
    public int age;
    public String place;
    public Boolean sex;
    public String friendname;
    //public User friend;
    //public Boolean ishavefriend = false;
    //public int image;
    public int character;

    public User(String name,String password,String username,String signature, String introduction,int age,String place,Boolean sex) {
        this.name = name;
        this.password = password;
        this.account = username;
        this.sex = sex;
        this.signature = signature;
        this.introduction  = introduction;
        this.age = age;
        this.place = place;
    }
    public User(String name,String password,String username,Boolean sex) {
        this.name = name;
        this.password = password;
        this.account = username;
        this.sex = sex;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {return name;}
    public String getSignature() {return signature;}
    public String getUsername() {return account;}
    public String getIntroduction() {return introduction;}
    public String getPlace() {return place;}
    public int getAge() {return age;}
    public Boolean getSex() {return sex;}
    /*public void setimage(int image) {
        this.image = image;
    }*/
}
