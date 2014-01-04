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
        while(true){
            System.out.println("Please enter restaurant name: ");
            String name = null;
            if(userInput1.hasNext()){
                name = userInput1.next();
            }
            if(!FileHandler.containsName(name)){
                System.out.println("Name already exists!");
            }else{
                String[] tags = new String[5];
                System.out.print("\nPlease enter tags seperated by spaces: ");
                for(int i = 0; i < tags.length; i++){
                    if(userInput1.hasNext()){
                        tags[i] = userInput1.next();
                    }
                    else{
                        break;
                    }
                }
                FileHandler.addName(name,tags);
            }
        }
    }
    
    static void findInterface() throws IOException{
        while(true){
            Scanner userInput1 = new Scanner(System.in);
            userInput1.useDelimiter(" |/n");
            System.out.println("Enter tags: ");
            String tags = userInput1.next();
            ArrayList<String> nameList = FileHandler.findNames(tags);
            if(nameList == null){
                System.out.println("Nothing was found that matched!");
            }
            for(int i = 0; i < nameList.size(); i++){
                System.out.println(nameList.get(i));
            }
        }
    }
}
