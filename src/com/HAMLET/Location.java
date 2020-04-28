package com.HAMLET;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final String description;
    private final int LocationId;
    private final Map<String,Integer> exits;

    public Location( int locationId,String description, Map<String, Integer> exits) {
        this.description = description;
        LocationId = locationId;
        if ( exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        }else{
            this.exits = new HashMap<String,Integer>();
        }

        this.exits.put("Q",0);
    }

//    public void addExit(String location,int description){
//        exits.put(location,description);
//    }

    protected void addExit(String description,int location){
        exits.put(description,location);
    }

    public String getDescription() {
        return description;
    }

    public int getLocationId() {
        return LocationId;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String,Integer>(exits);
    }
}
