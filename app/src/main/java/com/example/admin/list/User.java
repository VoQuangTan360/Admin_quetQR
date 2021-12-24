package com.example.admin.list;

public class User {
        public String ht,cv,iddoor,in_out;

    public User() {
    }

    public User(String ht, String cv, String iddoor, String in_out) {
        this.ht = ht;
        this.cv = cv;
        this.iddoor = iddoor;
        this.in_out = in_out;
    }

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getIddoor() {
        return iddoor;
    }

    public void setIddoor(String iddoor) {
        this.iddoor = iddoor;
    }

    public String getIn_out() {
        return in_out;
    }

    public void setIn_out(String in_out) {
        this.in_out = in_out;
    }
}
