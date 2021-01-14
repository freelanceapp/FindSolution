package com.semicode.findsolution.data.model;


public class UserModel {
    String name ;
    String jop ;
    String location ;
    String kind ;

    public UserModel(String name, String jop, String location, String kind) {
        this.name = name;
        this.jop = jop;
        this.location = location;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
