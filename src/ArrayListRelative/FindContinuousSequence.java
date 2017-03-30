package ArrayListRelative;

import java.util.ArrayList;

/**
 * Created by renguifu on 2017/3/12.
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum <3){
            return result;
        }
        int small = 1;
        int big =2;
        // 当big大于中间值的时候，前面的和肯定大于sum
        int middle = (sum +1)/2;
        int curSum = small + big;
        while(small < middle){
            if(curSum == sum){
                result.add(getList(small,big));
            }
            while(curSum > sum &&  small <middle){
                curSum =curSum -small;
                small ++;
                if(curSum == sum){
                    result.add(getList(small,big));
                }
            }
            big ++;
            curSum = curSum +big;
        }
        return result;
    }
    public ArrayList<Integer> getList(int small,int big){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =small;i<=big;i++){
            result.add(i);
        }
        return result;
    }
}
