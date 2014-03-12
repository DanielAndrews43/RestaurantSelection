/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantselection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danielandrews
 */
public class RestaurantSelection {

    /**
     * @param args the command line arguments
     */
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        try{
            while(running){
                System.out.println("Add names or find restaurants?");
                System.out.print("Enter 'add', 'find', or 'end': ");
                String operation = userInput.next();
                if(operation.equals("add")){
                    UserHandler.addInterface();
                }
                else if(operation.equals("find")){
                    UserHandler.findInterface();
                }
                else if(operation.equals("end")){
                    running = false;
                }
                else{
                    System.out.println("Please enter valid input");
                }
            }
        }
        catch(IOException e){
            System.err.println("Input/Output failure. Results not saved");
        }
        catch(IllegalStateException e){
            System.err.println("Failure with scanners. Please report");
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
