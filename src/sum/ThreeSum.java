package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by renguifu on 2017/1/9.
 * proplem:
 * Given an array S of n integers,
 * are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lf = i + 1;
            int rf = nums.length - 1;
            int sum = 0 - nums[i];
            while (lf < rf) {
                if (nums[lf] + nums[rf] == sum) {
                    result.add(Arrays.asList(nums[i], nums[lf], nums[rf]));
                    while (lf < rf && nums[lf] == nums[lf + 1]) lf++;
                    while (lf < rf && nums[rf] == nums[rf - 1]) rf--;
                    lf++;
                    rf--;
                } else if (nums[lf] + nums[rf] < sum) lf++;
                else rf--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] sums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> results = ts.threeSum(sums);
        for (List<Integer> result : results) {
            for (Integer tmp : result) {
                System.out.print(tmp + "\t");
            }
            System.out.print("\n");
        }
    }
}
