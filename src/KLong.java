import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;
import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

//恐龙类
public class KLong {
    public int x,y;
    BufferedImage image;
    BufferedImage image1,image2,image3,image_over;
    int stepTime = 0;
    int fresh ;
    //int fresh = GamePanl.FRESH;

    boolean jumpState = false;
    int jumpHeight = 100;
    final int LOWEST_Y = 200;
    int jumpValue = 5;

    //恐龙方法
    public KLong(){
        try{
            image1 = ImageIO.read(new File("image/long1.png"));
            image2 = ImageIO.read(new File("image/long2.png"));
            image3 = ImageIO.read(new File("image/long3.png"));
            image_over = ImageIO.read(new File("image/over.png"));
        }catch (Exception e){
               e.printStackTrace();
        }
        x = 50;
        y = LOWEST_Y;




    }
    //移动
    public void move(){
        step();
        if ( y >= LOWEST_Y){
            jumpValue = -4;
        }
        if ( y <= LOWEST_Y){
            jumpValue = 4;
        }
        y = y +jumpValue;
        if (y >= LOWEST_Y){
            jumpState = false;
        }



    }
    //踏步
    private void step() {
        int tmp = stepTime / 100 % 2;
        if (tmp == 1){
            image = image1;
        }else {
            image = image2;
        }
        stepTime = stepTime +  fresh;
    }

    //跳跃
    public void jump(){
        jumpState = true;
    }
    //接触死亡区域

    public Rectangle bound1(){
        return new Rectangle(x+20,y,20,10);
    }

    public Rectangle bound2(){
        return new Rectangle(x+5,y+35,20,10);
    }



}
