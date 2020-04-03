import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.swing.*;
import java.awt.*;


//线程类
public class FreshThread extends Thread {
    GamePanl gp;


    public FreshThread(GamePanl gp) {
        this.gp = gp;

    }

    public void run(){
        while(!gp.isFinish()){
            gp.repaint();//重新绘制图片
             try{
                 Thread.sleep(gp.FRESH);//休眠刷新时间
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
        }
        Container c = gp.getParent();
        while (!( c instanceof MainFrame)){
            c.getParent();
        }
        MainFrame f = (MainFrame) c;
        JOptionPane.showMessageDialog(f,"       GAME OVER");

        f.restart();




    }


}
