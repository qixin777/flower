/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author xxx
 */
 public class FileUtils {
    public static BufferedImage loadImage(String imagePath){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
            System.out.println("Image loaded: "+imagePath);
        } catch (IOException e) {
            System.out.println("Problem loading image: "+imagePath);
            e.printStackTrace();
        }
        return image;
    }
    
    public static ArrayList<String> getFileNames(String dirPath){
        ArrayList<String> names = new ArrayList<String>();
        File dir = new File(dirPath);
        if(dir.isDirectory()){
            for(File f: dir.listFiles()){
                names.add(f.getPath());
            }
        }
        return names;
    }
    //找那个放图片的文件夹
    public static boolean saveFlowerToFile(ArrayList<ImageDisplay> toWrite) {
        try{ 
            FileWriter fw = new FileWriter("./res/zoo.txt", false);
            for(ImageDisplay im: toWrite){
                fw.write(im.toString());
                }
            fw.flush();
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Zoo saved to file\n");
        return true; 
    } //把做好的那个 图片的数据 存放起来
    
    public static void readFlowerFromFile(){
        Path filePath = Paths.get("./res/text.txt");
        if(!Files.exists(filePath)){
            System.out.println("There is no file to read from.");
        }
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if(line.startsWith("ImageDisplay")){
                    imageSplitFromString(line);
                }
                else{
                    System.out.println("Bad line in file: "+line);
                }   
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + filePath);
            e.printStackTrace();
        }
    }
    
    private static void imageSplitFromString(String line){
        String[] data = line.split(",");
        String[] d1 = data[1].split("=");
        int x = Integer.parseInt(d1[1]);
        String[] d2 = data[2].split("=");
        int y = Integer.parseInt(d2[1]);
        String[] d3 = data[3].split("=");
        int w = Integer.parseInt(d3[1]);
        String[] d4 = data[4].split("=");
        int h = Integer.parseInt(d4[1]);
        String[] d5 = data[5].split("=");
        Garden.addImage(d5[1], x, y, w, h);
    } 
}
