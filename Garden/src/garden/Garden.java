/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

/**
 *
 * @author Administrator
 */
public class Garden {
    int id;
    int height;
    int weight;
    int xLocation;
    int yLocation;
    int[][] types;
    Flower[][] flowers;
    /**
     * @param args the command line arguments
     */
    
    public Garden()
    {
        
    }
    public Garden(int id,int height,int width,int x,int y)
    {
        this.id=id;
        this.height=height;
        this.weight=width;
        this.xLocation=x;
        this.yLocation=y;
    }
    
    public Garden(int id,int height,int width,int x,int y,int[][] tM)
    {
        this.id=id;
        this.height=height;
        this.weight=width;
        this.xLocation=x;
        this.yLocation=y;
        this.types=tM;
    }
    
    public Garden(Garden n,int[][] m)
    {
        this(n.id,n.height,n.weight,n.xLocation,n.yLocation);
        this.types=m;
        initializeFlowerArray();
    }
    
    public void initializeFlowerArray()
    {
        flowers=new Flower[height][weight];
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<weight;j++)
            {
                flowers[i][j]=new Flower(types[i][j],i,j);
            }
        }
    }
}
