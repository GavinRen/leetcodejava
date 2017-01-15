package ArrayListRelative;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renguifu on 2017/1/15.
 */
public class ArrayListRelative {
    // 输入为n,输出为list,里面代表着1 - n的数字，当是3的倍数的时候 用“Fizz”代表，是5的倍数的时候用“Buzz”代表，如果
    // 是3和5的倍数的时候用“FizzBuzz”，本方法不采用%符号实现
    public List<String> fizzBuzz(int n){
        List<String> ret = new ArrayList<>();
        for(int i=1,fizz=0,buzz=0; i<=n; i ++){
            fizz++;
            buzz++;
            if(fizz ==3 && buzz == 5){
                ret.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            }else if(fizz == 3){
                ret.add("Fizz");
                fizz =0;
            }else if(buzz == 5){
                ret.add("Buzz");
                buzz =0;
            }else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }
    public static void main(String[] args){
        ArrayListRelative alr =new ArrayListRelative();
        List<String> results= alr.fizzBuzz(15);
        for(String result :results){
            System.out.println(result);
        }
    }
}
