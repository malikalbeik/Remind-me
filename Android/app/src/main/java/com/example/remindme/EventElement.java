package com.example.remindme;

import com.google.gson.annotations.SerializedName;

public class EventElement {


    int gepoints;
    @SerializedName("id")
    int Id;
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("location")
    String location;
    @SerializedName("time")
    String date;

    public EventElement(int id, String name, String des, String location, String date) {
        this.Id = id;
        this.name = name;
        this.description = des;
        this.location = location;
        this.date = date;
    }




    public int getId() {
        return Id;
    }

    public int getGepoints() {
        return gepoints;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}