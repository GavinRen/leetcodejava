package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by renguifu on 2017/1/10.
 * problem:
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums,int target){
        ArrayList<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i >0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if (j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int sums=target-nums[i]-nums[j];
                int lf=j+1;
                int rf=nums.length-1;
                while(lf<rf){
                    if(nums[lf]+nums[rf]==sums){
                        result.add(Arrays.asList(nums[i],nums[j],nums[lf],nums[rf]));
                        lf++;
                        rf--;
                        while(lf<rf && nums[lf]==nums[lf-1]){
                            lf++;
                        }
                        while(lf<rf && nums[rf]==nums[rf+1]){
                            rf--;
                        }
                    }else if(nums[lf]+nums[rf]<sums){
                        lf++;
                    }else{
                        rf--;
                    }

                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums={1, 0, -1, 0, -2, 2};
        FourSum fs=new FourSum();
        List<List<Integer>> results=fs.fourSum(nums,0);
        for(List<Integer> result:results){
            for(Integer tmp:result){
                System.out.print(tmp+"\t");
            }
            System.out.print("\n");
        }
    }
}
