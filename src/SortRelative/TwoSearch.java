package SortRelative;

/**
 * Created by renguifu on 2017/3/11.
 */
public class TwoSearch {
    // 时间复杂度太高
    public int GetNumberOfK(int [] array , int k) {
        // 采用二分查找的思想
        if(array == null || array.length ==0){
            return -1;
        }
        int count =0;
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int middle = (left + right)/2;
            if(array[middle]==k){
                count++;
                // 判断左侧是否还是等于k
                int mLeft = middle -1;
                while(mLeft >= left && array[mLeft]==k ){
                    count++;
                    mLeft --;
                }
                int mRight = middle +1;
                // 判断右侧是否等于k
                while(mRight <= right && array[mRight]==k){
                    count++;
                    mRight ++;
                }
                return count;
            }else if(array[middle]< k){
                left = middle +1;
            }else{
                right = middle +1;
            }

        }
        return count;
    }
    // 采用二分查找的思想，分布找出第一次出现的值和最后一次出现的值
    // 时间复杂度为O（logn）
    public int GetNumberOfK1(int [] array , int k) {
        if(array == null && array.length ==0){
            return -1;
        }
        int first = getFirst(array,k);
        int last = getLast(array,k);
        if(first == -1 || last == -1){
            return 0;
        }
        int count = last -first +1;
        return count;
    }
    // 查找数字第一次出现的位置
    public int getFirst(int[] array,int k){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            // 取中间位置
            int middle = (left + right) /2;
            // 当值相同时，判断是否是第一个
            if(array[middle] ==k){
                if(middle ==0 || (middle >0 && array[middle-1]!= k)){
                    return middle;
                }else {
                    right = middle -1;
                }
            }
            else if(array[middle] > k){
                right = middle -1;
            }else{
                left = middle +1;
            }
        }
        return -1;
    }
    // 查找数字最后一次出现的位置
    public int getLast(int[] array,int k){
        int left =0;
        int right = array.length -1;
        while(left <= right){
            int middle = (left + right)/2;
            if(array[middle] ==k){
                if(middle == array.length -1 || (middle < array.length && array[middle +1] !=k)){
                    return middle;
                }else{
                    left =middle +1;
                }
            }
            else if(array[middle] > k){
                right = middle -1;
            }else{
                left = middle +1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        TwoSearch ts = new TwoSearch();
        int[] data ={1,2,3,3,3,4,5};
        System.out.println(ts.GetNumberOfK(data,3));
    }
}
