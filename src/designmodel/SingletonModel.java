package designmodel;

/**
 * Created by renguifu on 2017/1/26.
 * 实现singleton单例模式
 * 该解法只适合于单线程的时候工作正常
 * 线程不安全
 */
public class SingletonModel implements Runnable{
    private static SingletonModel instance;
    private SingletonModel(){

    }
    public static SingletonModel getInstance(){
        if (instance==null){
            return  new SingletonModel();
        }else{
            return instance;
        }
    }
    public void run(){
        System.out.println("这是单线程");
    }
    public static void main(String [] args){
        SingletonModel sm = new SingletonModel();

    }
}
