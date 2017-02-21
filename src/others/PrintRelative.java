package others;

/**
 * Created by renguifu on 2017/2/14.
 */
public class PrintRelative {
    public void Print1ToMaxNDigits(int n){
        if(n <= 0 || n>= 999){
            throw new RuntimeException("输入为非正数");
        }
        if(n <= 999){
            for(int i=1;i <= n;i++){
                System.out.print(i + "\t");
            }
        }else {
            for(int i =1;i <=999;i++){
                System.out.print(i+"\t");
            }
        }
    }
}
