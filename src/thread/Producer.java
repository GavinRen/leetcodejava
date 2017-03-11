package thread;

/**
 * Created by renguifu on 2017/3/2.
 */
public class Producer implements Runnable {
    private int num =2;
    private Storage storage;
    public Producer(Storage storage){
        this.storage = storage;
    }
    @Override
    public void run() {
        preduce(num);
    }
    public void preduce(int num){
        storage.preduce(num);
    }
    public void setNum(int num){
        this.num=num;
    }

}
