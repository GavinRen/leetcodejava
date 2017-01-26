package designmodel;

/**
 * Created by renguifu on 2017/1/26.
 * 相较于解法4，该方法采用内部类的方式，只有当调用SingletonHold.instance时，
 * 才会加载初始化，防止过早地创建实例
 * 比较好的解法
 */
public class SingletonModel4 {
    private static class SingletonHold{
        private static final SingletonModel4 instance = new SingletonModel4();
    }
    private SingletonModel4(){}
    public static SingletonModel4 getInstance(){
        return SingletonHold.instance;
    }
}
