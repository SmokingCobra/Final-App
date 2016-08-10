package com.jonschold.fragmentlayout;

public class BandLocation {

    private int _id;
    private String name;
    private String latitude;
    private String longitude;

    public BandLocation(){}

    public BandLocation(int _id, String name, String lat, String lon){
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
    }

    public void setAll(int _id, String name, String lat, String lon){
        this._id = _id;
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
    }

    public int get_id(){
        return _id;
    }

    public String getName(){
        return name;
    }

    public String getLat(){
        return latitude;
    }

    public String getLon(){
        return longitude;
    }

    public void set_id(int _id){
        this._id = _id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLat(String lat){
        this.latitude = lat;
    }

    public void setLon(String lon){
        this.longitude = lon;
    }

}
