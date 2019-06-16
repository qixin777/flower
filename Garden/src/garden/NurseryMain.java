/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

import java.util.Scanner;
import garden.Quantity;
import static garden.Quantity.parterres;

/**
 *
 * @author Administrator
 */
public class NurseryMain {
    static View sv;
    static Txt tu;
    static Scanner scan;
    static String filePath="./res/test.txt";
        static void delete(Scanner scan) throws Exception
    {
        System.out.println("choose which parterre you want to delete");
        int num=scan.nextInt();
        Quantity.parterres.remove(num);
    }
    
    static void start()
    {
        String str=tu.read(filePath,null);
        if(str.length()>5)
        {
            String[] strCount=str.split("\\n");
            int count=strCount.length;
           // System.out.println("count="+count);
        
            for(int i=0;i<count&&strCount[i]!=""&&strCount[i]!=null;i++)
            {
          //  System.out.println("i="+i);
          //  System.out.println(strCount[i]);
            String[] strArr=strCount[i].split("\\|");
            int id=Integer.parseInt(strArr[0]);
            int height=Integer.parseInt(strArr[1]);
            int width=Integer.parseInt(strArr[2]);
            int x=Integer.parseInt(strArr[3]);
            int y=Integer.parseInt(strArr[4]);
            int[][] types=new int[height][width];
            int k=0;
            for(int m=0;m<height;m++)
            {
                for(int n=0;n<width;n++)
                {
                    types[m][n]=Integer.parseInt(""+strArr[5].charAt(k));
                    k++;
                }
            }
            Garden p=new Garden(id,height,width,x,y);
            Garden parterre=new Garden(p,types);
            Quantity.parterres.add(parterre);
            }
        }
        
    }
    public static void  setAppearance(View mf,Scanner scan)   //change the appearance of parterre
    {
         System.out.println("choose one to set Shape:");
        int index=scan.nextInt();
        System.out.println("choose the Shape:");
        System.out.println("1.square");
        System.out.println("2.stripes");
         int shapeIndex=scan.nextInt();      //set the shape
         if(shapeIndex==1)      // square shape
         {
             for(int k=0;k<parterres.size();k++)
                {
                    Garden item = parterres.get(k);
                    if(index==item.id)
                    {
                    int xLocation=item.xLocation;
                    int yLocation=item.yLocation;
                    int flowerWidth=item.weight;
                    int flowerHeight=item.height;
                    
                    for(int i=0;i<flowerWidth;i++)
                    {
			for(int j=0;j<flowerHeight;j++)
			{
                            if(j==0||i==0||i==flowerWidth-1||j==flowerHeight-1)
                            {
                                item.types[i][j]=1; //change the picture
                            }else{
                                item.types[i][j]=2; //change the picture
                            }	
			}
                    }
                }
                }
         }else{                         // stripes shape
             for(int k=0;k<parterres.size();k++)
                {
                    Garden item = parterres.get(k);
                   if(index==item.id)
                    {
                    int xLocation=item.xLocation;
                    int yLocation=item.yLocation;
                    int flowerWidth=item.weight;
                    int flowerHeight=item.height;
                    
                    for(int i=0;i<flowerWidth;i++)
                    {
			for(int j=0;j<flowerHeight;j++)
			{
                            if(j%2==0)
                            {
                                item.types[i][j]=1; //change the picture
                            }else{
                                item.types[i][j]=2; //
                            }	
			}
                    }}
            }
         } 
        }
    static void restore()
    {
        String str="";
        for(Garden n:Quantity.parterres)
        {
            str+=n.id+"|"+n.height+"|"+n.weight+"|"+n.xLocation+"|"+n.yLocation+"|";
            for(int i=0;i<n.height;i++)
            {
                for(int j=0;j<n.weight;j++)
                {
                    str+=n.types[i][j];
                }
            }
            str+="\n";
        }
        
        tu.write(filePath,str,false);
    }
    public static void main(String args[])
    {
        start();
        Scanner scan=new Scanner(System.in);
        sv=new View();
        tu=new Txt();
        sv.repaint();
        int index=0;
        boolean flag=false;
        while(true&&!flag)
        {
            System.out.println("This is the parterre system,please choose your option");
            System.out.println("1.Add");
            System.out.println("2.Delete");
            System.out.println("3.shape");
            System.out.println("3.Exit and save");
            try{             
                index=Integer.parseInt(scan.nextLine());
                
                switch(index)
                {
                    case 1:add(scan);break;
                    case 2:delete(scan);break;
                    case 3:setAppearance(sv,scan);break;
                    case 4:flag=true;restore();sv.dispose();break;
                    default:System.out.println("What you inputed is valid,please input your option again.");break;
                }
                sv.repaint();
            }
            catch(Exception e)
            {
                System.out.println("What you inputed is valid,please input your option again.");
            }
        }
    }
    
    static void add(Scanner scan) throws Exception
    {
        int id=Quantity.parterres.size();
        System.out.println(id);
        int height=0;
        int width=0;
        int xLocation;
        int yLocation;
        int index=0;
       
        
        System.out.println("input the adding parterre's information");
        System.out.println("①count on hieght:");
        height=scan.nextInt();
        System.out.println("②count on width:");
        width=scan.nextInt();
        System.out.println("③x of location:");
        xLocation=scan.nextInt();
        System.out.println("④y of location:");
        yLocation=scan.nextInt();
        System.out.println("⑤which flower type you want（0,1,.....4）");
        index=scan.nextInt();
         int[][] types=new int[height][width];
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                types[i][j]=index;
            }
        }
        
        Garden nursery=new Garden(id,height,width,xLocation,yLocation,types);
        parterres.add(nursery);
    }
}
