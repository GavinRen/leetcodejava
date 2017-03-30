package ArrayListRelative;

import java.util.Arrays;

/**
 * Created by renguifu on 2017/3/12.
 */
public class IsContinus {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length !=5){
            return false;
        }
        Arrays.sort(numbers);
        int zeroCount=0;
        int start =0;
        while(numbers[start]==0){
            zeroCount++;
            start++;
        }
        int num =0;
        for(int i =start+1;i < numbers.length;i++){
            if(numbers[i]==numbers[i-1]){
                return false;
            }
            num = num + numbers[i]-numbers[i-1]-1;
        }
        return zeroCount>=num ? true:false;
    }
}
