package com.example.admin;

public class Product {
    private String gmail,name,position,id,in_out;

    public Product() {
    }

    public Product(String gmail, String name, String position, String id, String in_out) {
        this.gmail = gmail;

        this.name = name;
        this.position = position;
        this.id = id;
        this.in_out = in_out;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIn_out() {
        return in_out;
    }

    public void setIn_out(String in_out) {
        this.in_out = in_out;
    }

    @Override
    public String toString() {
        return "Product{" +
                "gmail='" + gmail + '\'' +

                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", id='" + id + '\'' +
                ", in_out='" + in_out + '\'' +
                '}';
    }
}
