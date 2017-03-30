import treerelative.TreeNode;

import java.util.ArrayList;

/**
 * Created by renguifu on 2017/1/12.
 */
public class Test {
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
//                System.out.println(element+"odd");
            }
        }
        if(evenArray.size()>0){
            for(int i=0;i <evenArray.size();i++){
                oddArray[index]=evenArray.get(i);
                index ++;
//                System.out.println(evenArray.get(i));
            }
        }
        array = oddArray;
        for(int ele:array){
            System.out.println(ele);
        }
    }
    public boolean isOrEven(int n){
        if((n & 1)==1){
            return false;
        }else{
            return true;
        }
    }
    public void swapAll(char[] data,int x,int y){
        int left =x;
        int right=y;
        while(left < right){
            char temp = data[left];
            data[left] = data[right];
            data[right] = data[left];
            left ++;
            right--;
        }
    }
    public void setInt(int a){
        a =10;
    }
    public void swap0(StringBuilder node){
        node.append("s");
    }
    public static void main(String[] args) {
        int a =5;
        Test t = new Test();
        char[] data ={'a','b','c'};
        t.swapAll(data,0,2);
        for(char b : data){
            System.out.println(b);
        }
//        t.setInt(a);
//        System.out.println(a);
//        Test t = new Test();
//        System.out.println(t.isOrEven(12));
//        int[] d={1,2,3,4,5,6,7};
//        int[] c = {1,3,5};
////        d = c;
//        t.reOrderArray(d);
//        for(int element:d){
//            System.out.println(element+"\t");
//        }
//        int x = 11;
//        int y = 15;
//        double zero =0;
//        double test =0.000;
//        System.out.println(zero == 0.00000000000001);
//        System.out.println((byte)11);
//        System.out.println(Integer.toBinaryString(11));
//        System.out.println(Integer.toBinaryString(15));
//        System.out.println(x >> 1);
//        System.out.println(x ^ y);
//        System.out.println(Integer.bitCount(x ^ y));
//        int count=0;
//        int xor =x ^ y;
//        for (int i =0;i<32;i++){
//            count += (xor >> i) & 1;
//        }
//        System.out.println(count);

    }
}
