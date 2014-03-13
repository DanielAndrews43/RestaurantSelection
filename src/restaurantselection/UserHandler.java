/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantselection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danielandrews
 */
public class UserHandler {
    static Scanner userInput1 = new Scanner(System.in);
    
    static void addInterface() throws IOException, FileNotFoundException{
        FileHandler names = new FileHandler("names.txt");
        while(true){
            System.out.print("Please enter restaurant name: ");
            String name = null;
            name = userInput1.nextLine();
            if(name.length() == 0){
                break;
            }
            if(FileHandler.containsName(name)){
                System.out.println("Name already exists!");
            }else{
                String[] tags = new String[2];
                System.out.print("Please enter exactly two tags seperated by a space: ");
                for(int i = 0; i < tags.length; i++){
                    tags[i] = userInput1.next();
                }
                
                names.addName(name,tags);
            }
//            System.out.print("Continue? y/n: ");
//            if(userInput1.next().equals("y")){
//                System.out.println();
//            }else{
//                return;
//            }
        }
    }
    
    static void findInterface() throws IOException{
        FileHandler names = new FileHandler("names.txt");
        while(true){
            Scanner userInput1 = new Scanner(System.in);
            System.out.print("Enter tag: ");
            String tag = userInput1.next();
            ArrayList<String> nameList = FileHandler.findNames(tag);
            if(nameList == null){
                System.out.println("Nothing was found that matched!");
            }
            else{
                System.out.println("\nout of: ");
                for(int i = 0; i < nameList.size(); i++){
                    System.out.print(nameList.get(i)+", ");
                }
                String rand = nameList.get((int)(Math.random()*nameList.size()));
                System.out.println("\n\nYou chose: " + rand + "\n");
                return;
            }
        }
    }
}
