/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

import java.awt.image.BufferedImage;

/**
 *
 * @author Administrator
 */
public class Flower {
    public static final int WIDTH=Quantity.WIDTH;
    public static final int HEIGHT=Quantity.HEIGHT;
    private int flowerX;//position x
    private int flowerY;//position y
    private int index;//which type the flower is;
    
    public Flower()
    {
        
    }
    
    public Flower(int index,int x,int y)
    {
        this.index=index;
        this.flowerX=x;
        this.flowerY=y;
    }
}
