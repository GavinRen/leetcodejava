package SortRelative;

import java.util.Random;

/**
 * Created by renguifu on 2017/2/7.
 */
public class ArraySort {
   // 选择排序
    public static void selectSort(int[] data){
        int minIndex =0;
        int temp;
        if(data ==null || data.length ==0){
            return ;
        }
        for(int i =0;i <data.length-1; i++){
            minIndex =i;
            for(int j = i+1;j <data.length; j ++){
                if(data[j] < data[minIndex]){
                    minIndex =j;
                }
            }
            if(minIndex != i){
                temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
    }
    // 冒泡排序
    public static void bubbleSort(int[] data){
        if (data== null || data.length==0){
            return;
        }
        int temp =0;
        for(int i = data.length-1;i >0; i--){
            for(int j =0;j< i; j ++){
                if(data[j +1] < data[j]){
                    temp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
    // 插入排序
    public static int[] insertionSort(int[] a){
        if(a ==null || a.length==0){
            throw new RuntimeException("the array is empty");
        }
        for(int i = 1;i < a.length; i ++){
            int temp = a[i];
            int j = i-1;
            while(j >=0 && a[j]>temp){
                a[j+1] =a[j];
                j--;
            }
            a[j+1] =temp;
        }
        return a;
    }
    // 希尔排序，是插入排序的一种只是改变了数据之间的间隔
    public static int[] shellSort(int[] a){
        if(a ==null && a.length==0){
            throw new RuntimeException("the array is empty");
        }
        // 计算出最大的h 值
        int h =1;
        while(h <=a.length / 3){
            h = h * 3 +1;
        }
        while(h >0){
            for(int i =h;i<a.length;i +=h){
                int temp = a[i];
                int j = i -h;
                while(j >= 0 && a[j] >temp){
                    a[j +h] =a[j];
                    j -=h;
                }
                a[j + h] =temp;
            }
            h = (h-1) /3;
        }
        return a;
    }
    // 归并排序
    public static void mergeSort(int[] data){
        int[] temp = new int[data.length];
        mergeSort(data,temp,0,data.length-1);
    }
    // 分成两路进行合并
    private static void mergeSort(int[] data,int[] temp,int left,int right){
        if(left < right){
            int center = (left + right) / 2;
            mergeSort(data,temp,left,center);//左子序列
            mergeSort(data,temp,center+1,right);// 右子序列
            merge(data,temp,left,center+1,right);// 合并两个已经排序的序列
        }
    }
    private static void merge(int[] data,int[] temp,int left,int rightPos,int right){
        int leftEnd = rightPos -1;
        int i =left;
        int j =rightPos;
        int k =0;
        while(i <= leftEnd && j <= right ){
            if(data[i] < data[j]){
                temp[k] =data[i];
                k ++;
                i ++;
            }else {
                temp[k] = data[j];
                k ++;
                j ++;
            }
        }
        while(i <= leftEnd ){
            temp[k] = data[i];
            k ++;
            i ++;
        }
        while(j <= right){
            temp[k] = data[j];
            k ++;
            j ++;
        }
        for(int n= 0;n < k;n ++ ){
            data[left+n] = temp[n];
        }

    }
    // 快速排序
    public static void quickSort(int[] data){
        if(data ==null || data.length ==0){
            return ;
        }
        quickSort2(data,0,data.length-1);
    }
    // 快速排序的主例程序
    private static void quickSort(int[] data,int left,int right){
        if (left >= right){
            return;
        }
        if(right -left < 2){
            if(data[left] > data[right]){
                swap(data,left,right);
                return;
            }
        }
        int pivot = medians(data,left,right);
//        int pivot = data[right];
        int i =left;
        int j = right-1;
        while(i < j){
            while(data[i] < pivot && i < j){
                i ++;
            }
            while(data[j] > pivot && i < j){
                j --;
            }
            swap(data,i,j);
        }
        swap(data,i,right);
        quickSort(data,left,i -1);
        quickSort(data,i+1,right);
    }
    // 利用中位数求枢纽
    private static int medians(int[] data,int left,int right){
        int center = (left + right) / 2;
        if(data[left] > data[center]){
            swap(data,left,center);
        }
        if(data[left] > data[right]){
            swap(data,left,right);
        }
        if(data[center] > data[right]){
            swap(data,center,right);
        }
        swap(data,center,right);// 枢纽元放到right-1
        return data[right];
    }
    // 数组元素交换
    private static void swap(int[] data,int x,int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
    // 最后一个元素作为枢纽
    private static void quickSort1(int[] data,int left,int right){
        if(left >= right){
            return;
        }
        int privot = data[right];
        int i = left;
        int j = right -1;
        while(true){
            while(data[i] < privot && i < j){
                i ++;
            }
            while(data[j] > privot && i < j){
                j --;
            }
            if(i < j){
                swap(data,i,j);
            }else{
                break;
            }
        }
        if(data[i]>= data[right]){
            swap(data,i,right);
        }else {
            i ++;
        }
        swap(data,i,right);
        quickSort1(data,left,i -1);
        quickSort1(data,i +1,right);
    }
    private static void quickSort2(int[] data,int left,int right){
        if(left >= right){
            return ;
        }
        int index = new Random().nextInt(right - left +1) +left;
        swap(data,index,right);
        int small = left -1;
        for(int i = left;i < right; i ++){
            if(data[i] < data[right] ){
                small ++;
                if(small != i){
                    swap(data,small,i);
                }
            }
        }
        small ++;
        swap(data,small,right);
        quickSort2(data,left,small-1);
        quickSort2(data,small+1,right);
    }
    public static void main(String[] args){
        int[] a = {34,54,64,51,32,21};
        ArraySort.quickSort(a);
        for( int b :a){
            System.out.println(b);
        }
    }
}
