package ArrayListRelative;

import java.util.Random;

/**
 * Created by renguifu on 2017/3/9.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length ==0){
            return "";
        }
        int left =0;
        int right = numbers.length - 1;
        quikSort(numbers,left,right);
        String result ="";
        for(int num:numbers){
            result+=num;
        }
        return result;
    }
    public void quikSort(int [] data,int left,int right){
        if (left >= right){
            return ;
        }
        int index = new Random().nextInt(right - left +1) +left;
        // 指向上一个大于选中值的位置
        int small = left -1;
        swap(data,index,right);
        for(int i=left;i< right;i++){
            if(compare(data[i],data[right])){
                small ++;
                if(small != i){
                    swap(data,small,i);
                }
            }
        }
        small ++;
        swap(data,small,right);
        quikSort(data,left,small-1);
        quikSort(data,small+1,right);
    }
    public void swap(int[] data,int x,int y){
        int temp = data[x];
        data[x] =data[y];
        data[y] = temp;
    }
    // 如果x小于y,返回true，否则false
    public boolean compare(int x,int y){
        String str1 = x +""+y;
        String str2 = y +""+x;
        if(str1.compareTo(str2)<0){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        PrintMinNumber test = new PrintMinNumber();
        System.out.println(test.compare(321,32));
    }
}
