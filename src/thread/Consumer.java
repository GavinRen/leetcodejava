package thread;

/**
 * Created by renguifu on 2017/3/2.
 */
public class Consumer implements Runnable {
    private int num ;
    private Storage storage;
    public Consumer(Storage storage){
        this.storage =storage;
    }
    @Override
    public void run() {
        try {
            consume(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void consume(int num) throws InterruptedException {
        storage.consume(num);
    }
    public void setNum(int num){
        this.num = num;
    }
}
