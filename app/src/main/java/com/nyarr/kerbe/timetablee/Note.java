package com.nyarr.kerbe.timetablee;

/**
 * Created by kerbe on 02.12.2017.
 */

public class Note {
    private String type;
    private int id;
    private String des;

    public Note(){}
    public Note(int id, String des, String type) {
        this.type = type;
        this.id = id;
        this.des = des;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
