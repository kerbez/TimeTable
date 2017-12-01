package com.example.kerbe.timetablee;

/**
 * Created by kerbe on 30.11.2017.
 */

public class DandW {
    private int id;
    private String des;
    private String day;
    private String hour;
    private String c;

    public DandW(){}
    public DandW(int id, String des, String day, String hour, String c) {
        this.id = id;
        this.des = des;
        this.day = day;
        this.hour = hour;
        this.c = c;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
