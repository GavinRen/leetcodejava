package SortRelative;

import java.util.ArrayList;

/**
 * Created by renguifu on 2017/2/14.
 * 问题：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *       所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 */
public class reOrderArray {
//    新建俩个数组，先把奇数放到这个数组，后把偶数放到这个数组
    public void reOrderArray(int [] array) {
        if(array == null && array.length==0){
            return;
        }
        int[] oddArray = new int[array.length];
        int index =0;
        ArrayList<Integer> evenArray = new ArrayList<>();
        for(int element:array){
            if(isOrEven(element)){
                evenArray.add(element);
            }else{
                oddArray[index] = element;
                index ++;
            }
        }
        if(evenArray.size()>0){
            for(int i=0;i <evenArray.size();i++){
                oddArray[index]=evenArray.get(i);
                index ++;
            }
        }
        for(int i=0;i<array.length;i++){
            array[i]=oddArray[i];
        }
    }
//    采用冒泡的思想进行排序

    public boolean isOrEven(int n){
        if((n & 1)==1){
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[] args){
        reOrderArray roa = new reOrderArray();
        int[] d ={1,2,3,4,5,6,7};
        roa.reOrderArray(d);
        for(int ele:d){
            System.out.println(ele);
        }
    }
}
