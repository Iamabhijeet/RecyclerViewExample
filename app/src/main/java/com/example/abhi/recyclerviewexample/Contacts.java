package com.example.abhi.recyclerviewexample;

/**
 * Created by abhi on 22-08-2016.
 */
public class Contacts {
    String name;



    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    String number;

    public Contacts(String name,String number){
        this.setName(name);
        this.setNumber(number);

    }

}
