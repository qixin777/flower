/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parterre;

import java.util.Scanner;
import parterre.Constant;


public class Main {
    static SurfaceView sv;
    static FileUtil fu;
    static Scanner scan;
 
    static String filePath="./resource/set.txt";
    public static void main(String args[])
    {
        enter();
        Scanner scan=new Scanner(System.in);
        sv=new SurfaceView();
        fu=new FileUtil();
        sv.repaint();
        int index=0;
        boolean flag=false;
        while(true&&!flag)
        {
            System.out.println("This is the parterre system,please choose your option");
            System.out.println("1.Add");
            System.out.println("2.Delete");
            System.out.println("3.Exit and save");
            try{
                index=scan.nextInt();
                switch(index)
                {
                    case 1:add(scan);break;
                    case 2:delete(scan);break;
                    case 3:flag=true;exit();sv.dispose();break;
                    default:System.out.println("What you inputed is valid,please input your option again.");break;
                }
                sv.repaint();
            }catch(Exception e)
            {
                System.out.println("What you inputed is valid,please input your option again.");
            }
        }
    }
    
    static void add(Scanner scan) throws Exception
    {
        int id=Constant.parterres.size();
        System.out.println(id);
        int height=0;
        int width=0;
        int xLocation;
        int yLocation;
        int index=0;
        
        System.out.println("input the adding parterre's information");
        System.out.println("①count on hieght:");
        height=scan.nextInt();
//        checkInt(height,true,1,100);
        System.out.println("②count on width:");
        width=scan.nextInt();
//        checkInt(width,true,1,100);
        System.out.println("③x of location:");
        xLocation=scan.nextInt();
//        checkInt(xLocation,false,0,0);
        System.out.println("④y of location:");
        yLocation=scan.nextInt();
//        checkInt(yLocation,false,0,0);
        System.out.println("⑤which flower type you want:(1:plane 2:cross stripe 3:vertical stripe)");
        index=scan.nextInt();
//        checkInt(index,true,0,2);
        
        parterreType(new Parterre(id,height,width,xLocation,yLocation),index,scan);
    }
    
    static void delete(Scanner scan) throws Exception
    {
        System.out.println("choose which parterre you want to delete");
        int num=scan.nextInt();
//        checkInt(num,true,0,Constant.parterres.size()-1);
        Constant.parterres.remove(num);
    }
    
    static void parterreType(Parterre p,int index,Scanner scan) throws Exception
    {
        int countH=p.countH;
        int countW=p.countW;
        int[][] tM=new int[countH][countW];
        switch(index)
        {
            case 0:
                System.out.println("you choose the \"plane\" type");
                System.out.println("please input the flower type:");
                int type=scan.nextInt();
                for(int i=0;i<countH;i++)
                {
                    for(int j=0;j<countW;j++)
                    {
                        tM[i][j]=type;
                    }
                }
                break;//plane
            case 1:
                System.out.println("you choose the \"cross stripe\" type");
                System.out.println("please input the count of cross stripes");
                int countTripes=scan.nextInt();
                int[] counts=new int[countTripes];
                int[] types=new int[countTripes];
                for(int i=0;i<countTripes;i++)
                {
                    System.out.println("choose the count of "+i+"th stripe");
                    counts[i]=scan.nextInt();
                    System.out.println("choose the type of "+i+"th stripe");
                    types[i]=scan.nextInt();
                }
                for(int i=0,k=0,m=0;i<countH&&k<countTripes;i++,k++)
                {
                    if(m>=counts[k])
                    {
                        m-=counts[k-1];
                    }
                    if(m<counts[k])
                    {
                        for(int j=0;j<countW;j++)
                        {
                            tM[i][j]=types[k];
                        } 
                        m++;
                    }
                }
                break;//cross stripe
            case 2:
                System.out.println("you choose the \"vertical stripe\" type");
                System.out.println("please input the count of vertical stripes");
                countTripes=scan.nextInt();
                counts=new int[countTripes];
                types=new int[countTripes];
                for(int i=0;i<countTripes;i++)
                {
                    System.out.println("choose the count of "+i+"th stripe");
                    counts[i]=scan.nextInt();
                    System.out.println("choose the type of "+i+"th stripe");
                    types[i]=scan.nextInt();
                }
                for(int i=0,k=0,m=0;i<countW&&k<countTripes;i++,k++)
                {
                    if(m>=counts[k])
                    {
                        m-=counts[k-1];
                    }
                    if(m<counts[k])
                    {
                        for(int j=0;j<countH;j++)
                        {
                            tM[j][i]=types[k];
                        } 
                        m++;
                    }
                }
                break;//vertical stripe
//            case 3:
//                System.out.println("you choose the \"diamond\" type");
//                types=new int[4];
//                for(int i=0;i<4;i++)
//                {
//                   System.out.println("please input the type of "+i+"th diamond"); 
//                   types[i]=scan.nextInt();
//                }
//                
//                
//                break;//diamond
            default:break;
        }
        
        Parterre parterre=new Parterre(p,tM);
        Constant.parterres.add(parterre);
    }
    
//    static void checkInt(int index,boolean range,int rangeMin,int rangeMax) throws Exception
//    {
//        if(index<0)
//        {
//            throw new Exception();
//        }
//        if(range)
//        {
//            if(index<rangeMin||index>rangeMax)
//            {
//                throw new Exception();
//            }
//        }
//    }
    
    static void enter()
    {
        String str=fu.read(filePath,null);
        if(str.length()>5)
        {
            
        
        String[] strCount=str.split("\\n");
        int count=strCount.length;
        System.out.println("count="+count);
        for(int i=0;i<count&&strCount[i]!=""&&strCount[i]!=null;i++)
        {
            System.out.println("i="+i);
            System.out.println(strCount[i]);
            String[] strArr=strCount[i].split("\\|");
            int id=Integer.parseInt(strArr[0]);
            int countH=Integer.parseInt(strArr[1]);
            int countW=Integer.parseInt(strArr[2]);
            int x=Integer.parseInt(strArr[3]);
            int y=Integer.parseInt(strArr[4]);
            int[][] tM=new int[countH][countW];
            int k=0;
            for(int m=0;m<countH;m++)
            {
                for(int n=0;n<countW;n++)
                {
                    tM[m][n]=Integer.parseInt(""+strArr[5].charAt(k));
                    k++;
                }
            }
            Parterre p=new Parterre(id,countH,countW,x,y);
            Parterre parterre=new Parterre(p,tM);
            Constant.parterres.add(parterre);
            }
        }
    }
    
    static void exit()
    {
        String str="";
        for(Parterre p:Constant.parterres)
        {
            str+=p.id+"|"+p.countH+"|"+p.countW+"|"+p.xLocation+"|"+p.yLocation+"|";
            for(int i=0;i<p.countH;i++)
            {
                for(int j=0;j<p.countW;j++)
                {
                    str+=p.typeMartrix[i][j];
                }
            }
            str+="\n";
        }
        
        fu.write(filePath,str,false);
    }
}
