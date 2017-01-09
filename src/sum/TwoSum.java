package sum;

import java.util.HashMap;

/**
 * Created by renguifu on 2017/1/9.
 * problem:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9
 * return [0, 1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] result = {map.get(target - nums[i]), i};
                return result;
            }
            map.put(nums[i],i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {1, 2, 3, 4, 6, 9};
        int[] datas = ts.twoSum(nums, 10);
        for (int data : datas) {
            System.out.println(data);
        }
    }
}
