package designmodel;

/**
 * Created by renguifu on 2017/1/26.
 *单利模式，线程安全，采用线程同步，不会出现同时调用getinstance
 * 加个同步锁
 */
public class SingletonModel1 implements Runnable{
    private static SingletonModel1 instance;
    private SingletonModel1(){}
    public static synchronized SingletonModel1 getInstance(){
        if(instance == null){
            instance = new SingletonModel1();
        }
        return instance;
    }
    public void run(){
        System.out.println("单例模式");
    }
    public static void main(String[] args){
        SingletonModel1 sm = SingletonModel1.getInstance();
        Thread td = new Thread(sm,"单利模式");
        td.start();

    }
}
