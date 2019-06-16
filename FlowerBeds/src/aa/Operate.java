/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author xxx
 */
public class Operate extends ImageDisplay {

    /**
     * @return the myMax
     */
    public int getMyMax() {
        return myMax;
    }

    /**
     * @param myMax the myMax to set
     */
    public void setMyMax(int myMax) {
        this.myMax = myMax;
    }

    /**
     * @return the myType
     */
    public String getMyType() {
        return myType;
    }

    /**
     * @param myType the myType to set
     */
    public void setMyType(String myType) {
        this.myType = myType;
    }

    /**
     * @return the myFlowers
     */
    public static ArrayList<Flower> getMyFlowers() {
        return myFlowers;
    }

    /**
     * @param aMyFlowers the myFlowers to set
     */
    public static void setMyFlowers(ArrayList<Flower> aMyFlowers) {
        myFlowers = aMyFlowers;
    }
    private static ArrayList<Flower>myFlowers = new ArrayList<>();
   // private final Enclosure myEnclosure ;
    
    private String myType;
    private int myMax = 100;
   
      
    public Operate(String imagePath,
            int myX,int myY,
            int myWidth,int myHeight){
        super(imagePath,myX,myY,myWidth,myHeight);    
    }
    public  void addFlowers(ArrayList<Flower> toAdd){
         Boolean allEqual = true;
         for(Flower flower:toAdd){
             if(!flower.equals(toAdd.get(0))){
                 allEqual = false;
                 break;  
             }
         }
         if(allEqual){
             for(Flower flower: toAdd){
                 this.addFlower(flower);
             }
         }
    }
    
    public boolean addFlower (Flower toAdd){
        boolean accepted = false;
        if(getMyFlowers().isEmpty()){
            getMyFlowers().add(toAdd);
            setMyType(toAdd.getName());
            this.add(toAdd);
            accepted = true;
            System.out.println("Flowers"+toAdd.getType()+"added to empety Garden");
        }
        else if (getMyFlowers().size()<getMyMax()){
            if(getMyType().equals(toAdd.getType())){
                getMyFlowers().add(toAdd);
                accepted = true;
                System.out.println("Flowers rejected for type"+toAdd.getType()+".Required="+getMyType());
            }
            else{
                System.out.println("Flowers rejected for type"+toAdd.getType()+".Required="+getMyType());
            }
            System.out.println("myFlower size ="+getMyFlowers().size());
        }
         
        return accepted;
    }
  
   }
   
   
     

        
    
   
   
       
         
   
    


