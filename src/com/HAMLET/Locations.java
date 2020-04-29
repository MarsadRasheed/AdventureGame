package com.HAMLET;


import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    public static Map<Integer, Location> locations = new HashMap<Integer, Location>();

//
//    public static void main(String[] args) throws IOException{
//
//        try(FileWriter locFile = new FileWriter("locations.txt");
//            FileWriter dirDir = new FileWriter("directions.txt")){
//
//            for(Location location : locations.values()){
//                locFile.write(location.getLocationId() + "," + location.getDescription() + "\n");
//                for(String direction : location.getExits().keySet()){
//                    dirDir.write(location.getLocationId() + "," + direction +"," +location.getExits().get(direction) + "\n");
//                }
//            }
//        }
//
//        /**
//        * Below code can be replaced by the above most efficient code having try with resources and main method throws exception
//        */
//
////
////        FileWriter locFile = null;
////
////        try{
////            for(Location location : locations.values()){
////                locFile.write(location.getLocationId() + "," + location.getDescription() + "\n");
////            }
////        } catch (IOException e){
////            System.out.println("In catch block");
////            e.printStackTrace();
////        } finally {
////            try{
////                if(locFile != null){
////                    locFile.close();
////                }
////            } catch (IOException e){
////                System.out.println("in finally block");
////                e.printStackTrace();
////            }
////        }
//
//
//    }

    static{


        // Read the locations

        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("locations_big.txt"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String desc = scanner.nextLine();
                System.out.println("location : " + loc + " : " + desc);
                Map<String,Integer> tempExits = new HashMap<>();
                locations.put(loc,new Location(loc,desc,tempExits));
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }

        // Now read the exits

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());

                String direction = scanner.next();
                scanner.skip(scanner.delimiter());

                String dest = scanner.nextLine();
                int destination = Integer.parseInt(dest);

                System.out.println(loc + ":" + direction + ":" + destination);
                Location location = locations.get(loc);
                location.addExit(direction,destination);

            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (scanner != null){
                scanner.close();
            }
        }

        // Adding Hard Data

//        Map<String,Integer> tempExits = new HashMap<String, Integer>();
//        locations.put(0,new Location(0,"you're standing in front of computer and finished the game",null));
//
//        tempExits = new HashMap<String,Integer>();
//        tempExits.put("W",2);
//        tempExits.put("E",3);
//        tempExits.put("S",4);
//        tempExits.put("N",5);
//        locations.put(1,new Location(1,"You're standing at the end of a road before a small brick building ",tempExits));
//
//        tempExits = new HashMap<String, Integer>();
//        tempExits.put("N",5);
//        locations.put(2,new Location(2,"you're at the top of a hill",tempExits));
//
//        tempExits = new HashMap<String, Integer>();
//        tempExits.put("W",1);
//        locations.put(3,new Location(3,"You're inside a building, a well house for a small spring",tempExits));
//
//        tempExits = new HashMap<String, Integer>();
//        tempExits.put("N",1);
//        tempExits.put("W",2);
//        locations.put(4,new Location(4,"You're in a welly inside a stream",tempExits));
//
//        tempExits = new HashMap<String, Integer>();
//        tempExits.put("S",1);
//        tempExits.put("W",2);
//        locations.put(5,new Location(5,"you,re in the forest",tempExits));


    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

}
