

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//恐龙类
public class KLong {
    public int x,y;
    BufferedImage image;
    BufferedImage image1,image2,image3,image_over;
    int stepTime = 0;
    int fresh = GamePanl.FRESH;

    boolean jumpState = false;//跳跃的状态
    int jumpHeight = 100; //t跳跃的高度
    final int LOWEST_Y = 200;//最低坐标
    int jumpValue = 5;//跳跃的增变量

    //恐龙方法
    public KLong(){
        try{
            image1 = ImageIO.read(new File("image/long1.png"));
            image2 = ImageIO.read(new File("image/long2.png"));
            image3 = ImageIO.read(new File("image/long3.png"));
            image_over = ImageIO.read(new File("image/over.png"));
        }catch (IOException e){
               e.printStackTrace();
        }
        x = 50;// 起始坐标x
        y = LOWEST_Y;//起始坐标y




    }
    //移动
    public void move(){
        step();//踏步
        if(jumpState){

        if ( y >= LOWEST_Y){   // y若大于等于200，则
            jumpValue = -4;
        }
        if ( y <= LOWEST_Y - jumpHeight){
            jumpValue = 4;
        }
        y = y + jumpValue;

        image = image3;
        if (y >= LOWEST_Y){
            jumpState = false;
        }}



    }
    //踏步
public void step() {
        int tmp = stepTime / 100 % 2;

        if (tmp == 1){
            image = image1;
        }else {
            image = image2;
        }
        stepTime +=  fresh;
    }

    //跳跃
    public void jump(){
        jumpState = true;
    }
    //接触死亡区域

    public Rectangle bounds1(){
        return new Rectangle(x+20,y,20,12);
    }

    public Rectangle bounds2(){
        return new Rectangle(x+5,y+35,20,10);
    }



}
