/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xxx
 */
public class UserInterface {
    private static Scanner kb;
    
    public static void menu(){
        kb = new Scanner(System.in);
        FileUtils.readFlowerFromFile();
        System.out.println("Gardens loaded\n");
        System.out.println("Welcome to my Zoo!\n");
        System.out.println("Please select:");
        System.out.println("1.\tAdd animal");
        System.out.println("2.\tRemove animal"); 
        System.out.println("3.\tSave the Zoo");
        System.out.println("4.\tload the Zoo");
        int command = getInt();
        switch(command){ 
            case 1:
                getInput();
                break;
            case 2:
                getFlowerInput();
                break;
            case 3:
                FileUtils.saveFlowerToFile(Garden.getGardens());
                break;
            default:
                System.out.println("Please input a value from 1 to 3");
        }
        menu();
        //这个是菜单栏 用户输入的那个
    }
    
    private static int getInt(){
        int input = 0;
        try{
            input = Integer.parseInt(kb.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("That is not an int; "
                                + "please try again");
            input = getInt();
        }
        finally{
            return input;    
        }
    } //这个是获得用户输入的数字 然后把String转换为数字
    
    private static void getInput(){
        System.out.println("Adding flowers.");
        ArrayList<String> fileNames = FileUtils.getFileNames("res" );
        System.out.println("Please enter the type of flower you want:");
        int counter = 1;
        
        for(String s:fileNames){
            if(s.endsWith(".png")){
                System.out.println(counter + ".\t Choose the type of flower as "+counter );
            }
            counter++;
        }
        int input = getInt();
        String path = fileNames.get(input);
        System.out.println("You selected the flower number is " + input);
        System.out.println("Please input location X");
        int myX = getInt();
        System.out.println("Please input location Y");
        int myY = getInt();
        System.out.println("Please input Height:");
        int height = getInt();
        System.out.println("Please input Width:");
        int width = getInt();
        Garden.addImageInput("./res/a.png", myX, myY, width, height);

       
    }//用户选择完图片后 图片怎么排排哪里
    
    private static void getFlowerInput(){
        System.out.println("Please input path to flower image:");
        int counter = 1;
        for(ImageDisplay s:Garden.getGardens()){
            System.out.println(counter + ".\t"+ s.toString());
            counter++;
        }
        int input = getInt() - 1;
        System.out.println("You selected " + Garden.getGardens().get(input).toString());
        String path = Garden.getGardens().get(input).getPath();
        Garden.removeImage(input,path);
        System.out.println("Image removing...");
    }
}