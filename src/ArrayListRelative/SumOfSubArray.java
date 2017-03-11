package ArrayListRelative;

/**
 * Created by renguifu on 2017/3/8.
 */
public class SumOfSubArray {
    // 连续子数组的最大和
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array ==null || array.length ==0){
            return -1;
        }
        int index =0;
        int size = array.length;
        int sum = array[0];
        int temp = 0;
        while(index < size){
            if(temp <0){
                temp = array[index];
            }else{
                temp = temp + array[index];
            }
            if(temp > sum){
                sum =temp;
            }
            index ++;
        }
        return sum;
    }
}
