

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


// 游戏面板
@SuppressWarnings("all")
public class GamePanl  extends JPanel implements KeyListener {
   //主图片
    BufferedImage image;
    //2D绘图工具
    Graphics2D g2;
    KLong klong;
    boolean finish = false;

    static final int FRESH = 10;
    BackgroundImage background;

    //障碍物集合
    List<obstacle> list = new ArrayList<obstacle>();

    int addObstacleTimer = 0;
    obstacle ob = new obstacle();

    //得分 分数
    int score = 0;
    int addScoreTimer = 0;

    //构造方法
    public GamePanl(){
        image = new BufferedImage(734,286,BufferedImage.TYPE_INT_BGR);
        g2 = image.createGraphics();
        klong = new KLong();
        background = new BackgroundImage();
        list.add(new obstacle());
        //System.out.println("list大小"+list.size());

        FreshThread t = new FreshThread(this);//刷新线程
        t.start();

    }

    //绘制图片
    private void painImage(){
        klong.move();
        background.roll();
        g2.drawImage(background.image,0,0,this);
        g2.drawImage(background.image_yun,background.x_yun,background.y_yun,this);
        g2.drawImage(klong.image,klong.x,klong.y,this);
        // System.out.println("addObstacleTimer :"+ addObstacleTimer);
        if (addObstacleTimer >= 1400 ){
        //    System.out.println("addObstacleTimer 2:"+ addObstacleTimer);
            list.add(new obstacle());
            addObstacleTimer = 0;
        }
       // System.out.println(list);
       // System.out.println("list最后大小："+ list.size());
        for (int i =0;i < list.size();i++){
            obstacle o = list.get(i);

            o.move();
            o.bridMove();
            g2.drawImage(o.image,o.x,o.y,this);//绘制障碍

            //判断障碍物是否和 头 、脚相撞
          if (o.bounds().intersects(klong.bounds1()) || o.bounds().intersects(klong.bounds2())){

                gameOver();
            }


        }
        //分数++
        if (addObstacleTimer >= 50){
            score += 1;

            addScoreTimer = 0;
        }

        //分数显示代码 ---"%05d"  --- 指以五位数显示
        g2.drawString(String.format("%05d",score),600,35);
        g2.drawString("Hi",536,35);
        g2.drawString(String.format("%05d",MainFrame.topScore),550,35);

        addObstacleTimer += FRESH;
        addScoreTimer    += FRESH;

    }
    //游戏结束
    public void gameOver() {
        finish = true;
        //image = background.image_over;
        g2.drawImage(background.image_over,background.x_over,background.y_over,null);
        if (score > MainFrame.topScore){//判断最高分
            MainFrame.topScore =score;
        }



    }

  /*  public void paint(Graphics2D g){
        painIamge();
        g.drawImage(image,0,0,this);

    }*/

@Override
    public void paint(Graphics g) {
        painImage();
        g.drawImage(image, 0, 0, this);
    }

    public boolean isFinish() {
        return finish;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
                  int code = e.getKeyCode();//获取 按键的编码

                 if(code == KeyEvent.VK_SPACE){
                     klong.jump();
                 }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
