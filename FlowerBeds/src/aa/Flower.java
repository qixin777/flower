/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa;

import java.util.ArrayList;

/**
 *
 * @author xxx
 */
public class Flower extends ImageDisplay {

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
    private String myType;
    
    public Flower(String imagePath, int myX,int myY,int myWidth,int myHeight){
        super(imagePath,myX,myY,myWidth,myHeight);
        myType=imagePath;
        System.out.println("Animal constructed:"+myType);
    }
    
    public String getType(){
        return getMyType();
    }
     public boolean equals(Flower other){
         if(this.getWidth()!=other.getWidth()){
             return false;
         }
         if(this.getHeight()!=other.getHeight()){
             return false;
         }
         if(!(this.getPath().equals(other.getPath()))){
             return false;
         }
         if(!(this.getType().equals(other.getType()))){
             return false;
         }
         return true;
     }

}
      
    
            
         
         

   
         
         
         
     
        
    

