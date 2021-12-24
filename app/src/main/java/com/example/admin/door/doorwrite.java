package com.example.admin.door;

public class doorwrite {
    public String id,name;

    public doorwrite() {
    }

    public doorwrite(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "doorwrite{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
