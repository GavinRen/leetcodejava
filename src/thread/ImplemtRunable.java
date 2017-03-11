package thread;

/**
 * Created by renguifu on 2017/3/2.
 */
public class ImplemtRunable implements Runnable{
    private int tichkets =5;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(tichkets>0){
                System.out.println("tickets ="+ tichkets--);
            }
        }
    }
    public static void main(String[] args){
        ImplemtRunable r = new ImplemtRunable();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
