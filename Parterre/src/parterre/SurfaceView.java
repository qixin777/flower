/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parterre;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
import static parterre.Constant.parterres;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SurfaceView extends JFrame {

    /**
     * Creates new form Main
     */
    FileUtil fu=new FileUtil();
    public SurfaceView() {
        initComponents();
        this.setTitle("Parterre");   //set the title of  View ,Paterre
        this.setVisible(true);    //set the Frame can be shown
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(102, 255, 102));
        setBounds(new java.awt.Rectangle(90, 90, 400, 400));

        jPanel1.setBackground(new java.awt.Color(102,205,0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public void repaint()    //paint parterre again after( add parterre, delete parterre, load parterre and etc..)
	{
            jPanel1.removeAll();   //清空之前的flower  remove all flower paint before
   
            for(Parterre p:parterres)
            {
                int countH=p.countH;
                int countW=p.countW;
                int xLocation=p.xLocation;
                int yLocation=p.yLocation;
                int[][]tM=p.typeMartrix;
                Flower[][] fa=p.fArray;
                
                try{
                    for(int i=0;i<countH;i++)
                    {
                        for(int j=0;j<countW;j++)
                        {
                            try{
                               String path=Constant.flowerImage[p.typeMartrix[i][j]];
                            
                               
                                BufferedImage image=ImageIO.read(new File(path));
                                FlowerPanel fp=new FlowerPanel(0,0,30,30,image);
                                jPanel1.add(fp);
                                fp.setBounds(xLocation+35*i,yLocation+35*j,30,30);
                            }catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                    
                } catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            jPanel1.repaint();   //repaint the panel
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    class FlowerPanel extends JPanel{
        private int x,y;
        private int width,height;
        private BufferedImage image;
        
        public FlowerPanel(){
            
        }
        
        public FlowerPanel(int x,int y,int width,int height,BufferedImage image){
            super();
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
            this.image=image;
            this.setLayout(null);
            this.setBackground(new Color(102,205,0));
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(image, x, y, width,height,this);
        }
        
    }
}

