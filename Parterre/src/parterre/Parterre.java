/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parterre;

public class Parterre {
    int id;
    int countH;
    int countW;
    int xLocation;
    int yLocation;
    int[][] typeMartrix;
    Flower[][] fArray;
    /**
     * @param args the command line arguments
     */
    
    public Parterre()
    {
        
    }
    public Parterre(int id,int height,int width,int x,int y)
    {
        this.id=id;
        this.countH=height;
        this.countW=width;
        this.xLocation=x;
        this.yLocation=y;
    }
    
    public Parterre(int id,int height,int width,int x,int y,int[][] tM)
    {
        this.id=id;
        this.countH=height;
        this.countW=width;
        this.xLocation=x;
        this.yLocation=y;
        this.typeMartrix=tM;
    }
    
    public Parterre(Parterre p,int[][] m)
    {
        this(p.id,p.countH,p.countW,p.xLocation,p.yLocation);
        this.typeMartrix=m;
        initializeFlowerArray();
    }
    
    public void initializeFlowerArray()
    {
        fArray=new Flower[countH][countW];
        for(int i=0;i<countH;i++)
        {
            for(int j=0;j<countW;j++)
            {
                fArray[i][j]=new Flower(typeMartrix[i][j],i,j);
            }
        }
    }
}
