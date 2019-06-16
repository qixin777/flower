 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa;

import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;

/**
 *
 * @author xxx
 */
public class Garden {

    /**
     * @return the gardens
     */
    public static ArrayList<ImageDisplay> getGardens() {
        return gardens;
    }

    /**
     * @param aGardens the gardens to set
     */
    public static void setGardens(ArrayList<ImageDisplay> aGardens) {
        gardens = aGardens;
    }

    /**
     * @param aMyAnimals the myAnimals to set
     */

    /**
     * @param aMyWindow the myWindow to set
     */
    public static void setMyWindow(JFrame aMyWindow) {
        myWindow = aMyWindow;
    }
    private static JFrame myWindow;
    private static ArrayList<ImageDisplay> gardens = new ArrayList<>();
    

    
    public static void main(String[] args) {
        setMyWindow(new JFrame());
        getMyWindow().setVisible(true); 
        getMyWindow().setBounds(200,200,800,800);
        getMyWindow().setAlwaysOnTop(true);
        getMyWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UserInterface.menu();
    }
    
  protected static void addImageInput(String imagePath, int x, int y, int width, int height){
       BufferedImage image = FileUtils.loadImage(imagePath);
        ImageDisplay myImage;
        
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                 myImage = new ImageDisplay(imagePath, x+j*25, y+i*25, 20,20);
                 getMyWindow().add(myImage);
                getGardens().add(myImage);
            }     
        }
         getMyWindow().repaint();
  }
    
    /**
     *
     * @param imagePath
     * @param x
     * @param y
     * @param width
     * @param height
     */
    protected static void addImage(String imagePath, int x, int y, int width, int height){
       BufferedImage image = FileUtils.loadImage(imagePath);
        ImageDisplay myImage;
   
        myImage = new ImageDisplay(imagePath, x, y, 20,20);
        getMyWindow().add(myImage);
        getGardens().add(myImage);   
      //  System.out.println("Image added: " + imagePath + "\n");
        getMyWindow().repaint();
       
    }
    
    protected static void removeImage(int input, String imagepath){
        getMyWindow().remove(getGardens().get(input));
        getGardens().remove(input);
        System.out.println("Image removed: " + imagepath + "\n");
        getMyWindow().repaint();
     
    }
    
    public static JFrame getMyWindow() {
        return myWindow;
    }
    
}
