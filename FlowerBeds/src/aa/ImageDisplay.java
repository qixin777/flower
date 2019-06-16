/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author xxx
 */
public class ImageDisplay extends JPanel {

    /**
     * @return the myImage
     */
    public Image getMyImage() {
        return myImage;
    }

    /**
     * @return the myPath
     */
    public String getMyPath() {
        return myPath;
    }

    /**
     * @return the myWidth
     */
    public int getMyWidth() {
        return myWidth;
    }

    /**
     * @return the myHeight
     */
    public int getMyHeight() {
        return myHeight;
    }

    /**
     * @return the myY
     */
    public int getMyY() {
        return myY;
    }

    /**
     * @param myY the myY to set
     */
    public void setMyY(int myY) {
        this.myY = myY;
    }

    /**
     * @return the myX
     */
    public int getMyX() {
        return myX;
    }

    /**
     * @param myX the myX to set
     */
    public void setMyX(int myX) {
        this.myX = myX;
    }
   private int myX;
   private int myY;
    private final int myHeight, myWidth;
    private final String myPath;
    private  final Image myImage;
    
    public ImageDisplay (String imagePath, int myX, int myY, int myWidth,  int myHeight)
    {
        this.myX = myX;
        this.myY = myY;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.myPath = imagePath;
        myImage = FileUtils.loadImage(imagePath);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(getMyImage(), 0, 0, getMyWidth(), getMyHeight(), this);
    }
    

    @Override
    public int getX() {
        return getMyX();
    }

    @Override
    public int getY() {
        return getMyY();
    }
    public void SetY(int y){
        this.setMyY(y);
      
}
   
    public void SetX(int x){
        setMyX(x);
}
    @Override
    public int getWidth() {
        return getMyWidth();
    }

    @Override
    public int getHeight() {
        return getMyHeight();
    }
    public String getPath() {
        return getMyPath();
    }
   
    @Override
    public String toString(){
        return "ImageDisplay" + ", myX=" + getMyX() +
                                ", myY=" + getMyY() +
                                ", myWidth=" + getMyWidth() +
                                ", myHeight=" + getMyHeight() +
                                ", myPath=" + getMyPath()+"\n";
    }
      
    
}
