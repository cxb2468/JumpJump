import javax.imageio.ImageIO;
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

    public KLong(){
        try{
            image1 = ImageIO.read(new File("image/long1.png"));
            image2 = ImageIO.read(new File("image/long2.png"));
            image3 = ImageIO.read(new File("image/long3.png"));
            image_over = ImageIO.read(new File("image/over.png"));
        }catch (Exception e){
               e.printStackTrace();
        }



    }




}
