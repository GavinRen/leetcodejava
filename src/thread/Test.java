package thread;

/**
 * Created by renguifu on 2017/3/2.
 */
public class Test {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer p = new Producer(storage);
        p.setNum(3);
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        Consumer c1 = new Consumer(storage);
        c1.setNum(3);
        Thread t1= new Thread(c1);

        Thread t2 = new Thread(c1);
        Thread t3 = new Thread(c1);
        t1.start();
        c1.setNum(2);
        t2.start();
        t3.start();
    }
}
