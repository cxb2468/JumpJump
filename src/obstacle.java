import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class obstacle {
    KLong klong = new KLong();
    Random r    = new Random();

    int x , y;
    public boolean judge = false;
    BufferedImage image;
    BufferedImage cactus01,cactus02,cactus03,bird1,bird2;
    int speed = BackgroundImage.SPEED - 1;
    int temp = r.nextInt(4) + 1;

    public obstacle(){
        //读取图片
        try{
            cactus01 = ImageIO.read(new File("image/cactus03.png"));
            cactus02 = ImageIO.read(new File("image/cactus02.png"));
            cactus03 = ImageIO.read(new File("image/cactus01.png"));
            bird1 = ImageIO.read(new File("image/bird1"));
            bird2 = ImageIO.read(new File("image/bird2"));



        }catch (Exception e){
            e.printStackTrace();
        }
        //初始位置
        x = 800;
        y = 209;

        //随机输出障碍物
        switch (temp){
            case 1:
                image = cactus01;
                break;
            case 2:
                image = cactus02;
                break;
            case 3:
                image = cactus03;
                y = 200;
                break;
            default:
                judge = true;
        }

    }
    //鸟的运动
    void birdMove(){
        if (judge){
            int tmp = klong.stepTime / 100 % 2;
            if (tmp == 1){
                image = bird1;
            }else {
                image = bird2;
            }
            klong.stepTime = klong.stepTime + klong.fresh;
        }
    }

    //滚动
    public void  move(){
        x = x - speed;
        x = x - speed;
    }

    //死亡区域
    public Rectangle bounds(){
        return new Rectangle(x,y+2,image.getWidth()-2,image.getHeight()-10);
    }
}
