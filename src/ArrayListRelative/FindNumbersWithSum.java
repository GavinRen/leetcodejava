package ArrayListRelative;

import java.util.ArrayList;

/**
 * Created by renguifu on 2017/3/12.
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array== null || array.length ==0){
            return result;
        }
        // 定义两个指针
        int left = 0;
        int right = array.length -1;

        while(left < right){
            // 如果相等的话返回
            if(array[left] + array[right] == sum){
                result.add(array[left]);
                result.add(array[right]);
                return result;
                // 如果小于的时候，左边指针加一
            }else if( array[left] + array[right]<sum){
                left++;
            }else{
                // 如果大于的时候，右边指针减一
                right --;
            }
        }
        return result;
    }
}
