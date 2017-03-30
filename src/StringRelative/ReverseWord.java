package StringRelative;

/**
 * Created by renguifu on 2017/3/12.
 */
public class ReverseWord {
    public String ReverseSentence(String str) {
        if(str == null){
            return null;
        }
        char[] strArray = str.toCharArray();
        // 交换数组
        swapAll(strArray,0,strArray.length-1);
        // 定义单词的首要位置
        int start =0;
        int end =0;
        while(end < strArray.length){
            // 找出来空格的所在的位置
            while(end < strArray.length && strArray[end] !=' '){
                end ++;
            }
            // 交换空格之前的单词
            swapAll(strArray,start,end-1);
            int temp = end;
            start = temp +1;
            end++;
        }
        return new String(strArray);
    }
    public void swapAll(char[] data,int x,int y){
        int left =x;
        int right=y;
        while(left < right){
            char temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            left ++;
            right--;
        }
    }
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() <n){
            return "";
        }
        char[] data = str.toCharArray();
        swapAll(data,0,data.length-1);
        swapAll(data,0,data.length-n-1);
        swapAll(data,data.length-n,data.length-1);
        return new String(data);
    }
}
