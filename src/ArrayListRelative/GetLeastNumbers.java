package ArrayListRelative;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by renguifu on 2017/2/27.
 * 问题：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(input ==null || input.length ==0 || input.length < k){
            return result;
        }
        Arrays.sort(input);
        for(int i =0;i <k;i++){
            result.add(input[i]);
        }
        return result;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(input ==null || input.length ==0 || input.length < k || k ==0){
            return result;
        }
        for(int i =0; i < k;i++){
            result.add(input[i]);
        }
        for(int i =k ;i<input.length;i++){
            int max = getMax(result);
            if(input[i]<max){
                result.remove(Integer.valueOf(max));
                result.add(input[i]);
            }
        }
        return result;
    }
    public int getMax(ArrayList<Integer> input){
        int max = input.get(0);
        for(int j =0;j<input.size();j++){
            if(input.get(j)> max){
                max =input.get(j);
            }
        }
        return max;
    }
}
