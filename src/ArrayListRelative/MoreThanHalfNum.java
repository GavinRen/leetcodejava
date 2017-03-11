package ArrayListRelative;

import java.util.HashMap;

/**
 * Created by renguifu on 2017/2/27.
 * 问题：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class MoreThanHalfNum {
    // 解法一：采用hashmap的方式时间复杂度为O（n）
    public int MoreThanHalfNum_Solution1(int [] array) {
        if(array==null || array.length ==0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = array.length;
        int middle = len/2;
        for(int i =0;i <len;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                map.put(array[i],map.get(array[i])+1);
            }
            if(map.get(array[i])>middle){
                return array[i];
            }
        }
        return 0;
    }
    // 利用数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其它所有数字出现次数的和还要多 这个特点
    public int MoreThanHalfNum_Solution2(int [] array) {
        if(array==null || array.length ==0){
            return 0;
        }
        int result = array[0];
        int time = 1;
        int len = array.length;
        for(int i =0;i <len ; i++){
            if(time ==0){
                result = array[i];
                time =1;
            }else if(array[i] == result){
                time ++;
            }else {
                time --;
            }
        }
        int count =0;
        for(int i =0; i<len;i++){
            if(array[i] == result){
                count++;
            }
        }
        if(count*2 >len){
            return result;
        }
        return 0;
    }
}
