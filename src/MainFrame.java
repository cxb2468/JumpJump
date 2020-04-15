import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class MainFrame extends JFrame {

    GamePanl gp;

    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gp = new GamePanl();

        Container c = getContentPane();
        c.add(gp);
        addKeyListener(gp);

    }
//主框架
    public static void main(String[] args){

        MainFrame frame = new MainFrame();

        frame.setBounds(340,220,734,320);

        frame.setVisible(true);

        frame.setLocationRelativeTo(null);

        frame.setName("恐龙跳一跳");
        System.out.println("main thread!"+ new Date().toString());
    }
//重新开始 ，把死掉的东西删掉，重新来过
    public void restart() {
        Container c = getContentPane();
        //删除所有死掉的组件
        c.removeAll();

        GamePanl gpr = new GamePanl();
        c.add(gpr);
        addKeyListener(gpr);

        c.validate(); //重新验证容器.组件






    }


    public static int topScore = 0;


}
