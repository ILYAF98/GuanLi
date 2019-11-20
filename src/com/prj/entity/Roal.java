package com.prj.entity;

public class Roal {
    private int id;
    private String rname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "Roal{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                '}';
    }
}
