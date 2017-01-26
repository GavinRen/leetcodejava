package designmodel;

/**
 * Created by renguifu on 2017/1/26.
 * 因为单例的实例被声明成 static 和 final 变量了，
 * 在第一次加载类到内存中时就会初始化，所以创建实例本身是线程安全的
 * 但是每一次加载类时就被初始化，过早穿件实例，从而降低内存的使用效率
 */
public class SingletonModel3 {
    private static final SingletonModel3 instance = new SingletonModel3();
    private SingletonModel3(){}
    public static SingletonModel3 getInstance(){
        return instance;
    }
}
