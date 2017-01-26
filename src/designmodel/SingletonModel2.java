package designmodel;

/**
 * Created by renguifu on 2017/1/26.
 * 只有在实例还没有创建之前需要加锁操作，以保证只有一个线程创建出实例，当创建出实例之后不需要同步
 * 双重检验锁，有两次判断，一次在代码块外，一次在代码块内，这是因为如果俩个线程同时到达代码块外的判断，
 * 里面不加同步，就会产生多个实例
 */
public class SingletonModel2 {
    private volatile static SingletonModel2 instance;
    private SingletonModel2(){}
    public static SingletonModel2 getInstance(){
        if(instance == null){
            synchronized(SingletonModel2.class){
                if(instance == null){
                    instance = new SingletonModel2();
                }
            }
        }
        return instance;
    }
}
