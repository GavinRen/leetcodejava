package thread;

/**
 * Created by renguifu on 2017/3/2.
 */
public class ExtendThread extends Thread {
    private int ticked =5;
    public void run(){
        for(int i =0;i<10;i++){
            if(ticked >0){
                System.out.println("ticket ="+ ticked--);
            }
        }
    }
    public static void main(String[] args){
        new ExtendThread().start();
        new ExtendThread().start();
    }
}
