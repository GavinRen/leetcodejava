package thread;

import java.util.LinkedList;

/**
 * Created by renguifu on 2017/3/2.
 */
public class Storage {
    private final int MAX_SIZE = 10;
    private LinkedList<Object> list = new LinkedList<>();

    public void preduce(int num){
        synchronized (list){
            while(list.size() + num >MAX_SIZE){
                System.out.println("要生产的数量加上"+list.size()+"超过了"+MAX_SIZE);
                try{
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }
            System.out.println("生产了"+num+"产品");
            list.notifyAll();
        }
    }
    public void consume(int num) throws InterruptedException {
        synchronized (list){
            while (list.size() < num){
                System.out.println("s数量不够消费");
                list.wait();
            }
            for (int i = 0; i<num;i++){
                list.remove();
            }
            System.out.println("已消费了"+num+"产品");
            list.notifyAll();;
        }
    }
}
