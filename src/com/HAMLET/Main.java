package com.HAMLET;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Locations Locations = new Locations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> myExit = new HashMap<>();
        myExit.put("Q",0);
        myExit.put("E",1);
        myExit.put("W",2);
        myExit.put("N",3);
        myExit.put("S",4);
        Locations.put(9,new Location(9,"You're going to start the game",myExit));

        Map<String,String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH","N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("EAST","E");
        vocabulary.put("WEST","W");

        System.out.println("\nEnter given exits or give a complete instruction\n");

        int loc = 9;
        while(true){
            System.out.println( Locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }

            Map<String,Integer> exits = Locations.get(loc).getExits();
            System.out.print("Available exits are : ");

            for(String exit : exits.keySet()){
                System.out.print(exit + ",  ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1){
                String[] words = direction.split(" ");
                for(String word : words){
                    if(vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else{
                System.out.println("you cannot go in that direction");
            }
        }

    }
}
