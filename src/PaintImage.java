

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class PaintImage extends JFrame {
    public PaintImage() {
        setBounds(200, 200, 1000, 500);
        setVisible(true);
        setTitle("绘图");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new mycanvas());
    }

    public static void main(String[] args) {
        new PaintImage().setVisible(true);
    }

    class mycanvas extends Canvas {//内部类

        public void paint(Graphics g) {
            Image image = new ImageIcon("image/map1.png").getImage();//获取图片资源
            g.drawImage(image, 100, 100, this);//绘制图像

        }
    }



}

