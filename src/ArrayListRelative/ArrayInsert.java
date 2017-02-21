package ArrayListRelative;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by renguifu on 2017/2/3.
 * 题目：有两个排序的数组A和B,内存在A末尾有足够多的空余空间，容纳B，
 * 请实现一个函数，把B中的所有数字插入到A中并且所有的数字是排序的
 * 思路：从尾到头复制比较A和B中的数字，并将较大的数字复制到A的合适位置
 */
public class ArrayInsert {
    public int insert(int[] A,int[] B,int length){
        int targetLength = B.length + length;
        if(A.length < targetLength){
            return -1;
        }
        if(B.length ==0){
            return length;
        }
        int temp = targetLength;
        int bLength = B.length;
        while(targetLength>0){
            if(bLength <= 0){
                A[targetLength -1] = A[length-1];
                length --;
            }else if(length <= 0){
                A[targetLength -1] = A[bLength-1];
                bLength --;
            }else if( A[length-1]>B[bLength-1]){
                A[targetLength -1] = A[length-1];
                length--;
            }else{
                A[targetLength -1] = B[bLength-1];
                bLength --;
            }
            targetLength --;
        }
        return temp;
    }
    public static void main(String[] args){
        int[] A = new int[30];
        A[0] = 1;
        A[1] = 3;
        A[2] = 5;
        A[3] = 7;
        A[4] = 11;
        A[5] = 13;
        int[] B = new int[3];
        B[0] = 6;
        B[1] = 8;
        B[2] = 10;
        System.out.println(new ArrayInsert().insert(A,B,6));
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
        stack.push(1);
        stack.pop();
    }
}
