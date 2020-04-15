

public class TestThreah {
    public  static void main(String[]  args) {

        new T().start();
        for (int i =0;i<10;i++){
            System.out.println("main thread 在运行:"+i);
        }




    }


}
class T extends Thread{
    public void run(){
        for (int i=11;i<21;i++){
            System.out.println("T第二线程在运行："+i);
        }
    }
}