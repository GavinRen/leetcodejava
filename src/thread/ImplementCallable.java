package thread;

import java.util.concurrent.Callable;

/**
 * Created by renguifu on 2017/3/2.
 */
public class ImplementCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return "hello world";
    }

    public static void main(String[] args) {

    }
}
