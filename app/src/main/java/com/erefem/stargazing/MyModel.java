package com.erefem.stargazing;

public class MyModel {
    String object_name = "";
    String observer = "";
    String coordinate = "";
    String date = "";
    String time = "";
    String seeing = "";
    String instrument = "";
    String magnification = "";
    String filter = "";
    String description = "";

    public MyModel(String object_name, String observer, String coordinate, String date, String time, String seeing, String instrument, String magnification,String filter, String description) {
        this.object_name = object_name;
        this.observer = observer;
        this.coordinate = coordinate;
        this.date = date;
        this.time = time;
        this.seeing = seeing;
        this.instrument = instrument;
        this.magnification = magnification;
        this.filter = filter;
        this.description = description;
    }

    public String getObject_name() {
        return object_name;
    }

    public void setObject_name(String object_name) {
        this.object_name = object_name;
    }

    public String getObserver() {
        return observer;
    }

    public void setObserver(String observer) {
        this.observer = observer;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeeing() {
        return seeing;
    }

    public void setSeeing(String seeing) {
        this.seeing = seeing;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getMagnification() {
        return magnification;
    }

    public void setMagnification(String magnification) {
        this.magnification = magnification;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
