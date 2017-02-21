package sum;

/**
 * Created by renguifu on 2017/2/8.
 */
public class FibonacciRelative {
    /** 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
    * n<=39
    */
    // 递归的方式求解，时间复杂度过高
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n - 2);
    }
    // 循环的方式
    public int Fibonacci1(int n) {
        if( n == 0 ){
            return 0;
        }
        if( n == 1){
            return 1;
        }
        int fibSecond = 0;
        int fibFirst = 1;
        int result = 0;
        for(int i = 2;i <= n; i ++){
            result = fibSecond + fibFirst;
            fibSecond = fibFirst;
            fibFirst = result;
        }
        return result;
    }
}
