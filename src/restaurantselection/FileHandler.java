/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package restaurantselection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * All things listed in the files are ordered "name / tags"
 * tags are separated by a space
 * @author danielandrews
 */
public class FileHandler {
    static String fileName = "names.txt";
    static File names;
    public FileHandler(String fileName) throws IOException{
        this.fileName = fileName;
        names = new File(fileName);
        if(!names.exists()){
            names.createNewFile();
        }
    }
    
    public static void addName(String name, String[] tags) throws IOException{
        //replace with "BufferedWriter out = getWriter();"
        File file = new File(FileHandler.fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        for (String tag : tags) {
            tag = tag.toLowerCase();
        }
        name = name.toLowerCase();
        //Find java version :P 
        String tagNames = "";
        for(int i = 0; i < tags.length; i++){
            if(i == 0){
                tagNames = tags[0];
            }else{
                tagNames = tagNames + "~~" + tags[i];
            }
        }
        writer.write(name + "~" + tagNames);
        writer.newLine();
        writer.close();
        System.out.println("Successfully added!");
    }
    
    static ArrayList<String> findNames(String tag) throws FileNotFoundException, IOException{
        tag = tag.toLowerCase();
        //replace with "BufferedReader in = getReader();"
        BufferedReader in = new BufferedReader(new FileReader(names));
        String line;
        ArrayList<String> nameList = new ArrayList<>();
        while((line = in.readLine())!= null){
            if(line.contains(tag)){
                nameList.add(FileHandler.onlyName(line));
            }
        }
        if(nameList.isEmpty()){
            return null;
        }
        return nameList;
    }
    
    static String onlyName(String line){
        String[] name;
        if(line.contains("~")){
            name = line.split("~");
            return name[0];
        }else{
            return null;
        }
    }
    
    static boolean containsName(String name) throws FileNotFoundException, IOException{
        //replace with "BufferedReader in = getReader();
        BufferedReader in = new BufferedReader(new FileReader(names));
        String line;
        while((line = in.readLine())!= null){
            if(line.contains(name)){
                return true;
            }
        }
        return false;
    }
    
    /*BufferedWriter getWriter() throws IOException{
        //Find out how to return a BufferedWriter...
        BufferedWriter out = new BufferedWriter(new FileWriter(names,true));
        return out;
    }
    
    BufferedReader getReader() throws IOException{
        //Find out how to return a BufferedReader...
        BufferedReader in = new BufferedReader(new FileReader(names));
        return in;
    }*/
}
