import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class BackgroundImage {

     BufferedImage image;
     BufferedImage image1, image2, image_over, image_yun;
     Graphics2D g2;

     int x1,x2;
     int x_yun=800,y_yun=50;
     int x_over=340,y_over=20;

     static final int SPEED = 3; //速度

    public BackgroundImage(){
        try{
            image1 = ImageIO.read(new File("image/map.png"));
            image2 = ImageIO.read(new File("image/map1.png"));
            image_over = ImageIO.read(new File("image/over.png"));
            image_yun  = ImageIO.read(new File("image/yun.png"));

        }catch (Exception e){
            e.printStackTrace();
        }
        image = new BufferedImage(734,286,BufferedImage.TYPE_INT_BGR);
        g2 = image.createGraphics();
        x1 = 0;
        x2 = 734;
        g2.drawImage(image1,x1,0,null);
        g2.drawImage(image2,x2,0,null);



    }

    //背景滚动方法
    public void roll(){
        x1 = x1 - SPEED;
        x2 = x2 - SPEED;

        if(x1 <= -734){
            x1 = 734;
        }
        if (x2 <= -734){
            x2 = 734;
        }
        g2.drawImage(image1,x1,0,null);
        g2.drawImage(image2,x2,0,null);
        x_yun = x_yun - 1;
        if (x_yun <= 0){
            g2.drawImage(image_yun,x_yun,y_yun,null);
            x_yun = 750;
            if ((y_yun= y_yun +26) < 80 ){
                y_yun = y_yun + 26;
            }
        }





    }








}
