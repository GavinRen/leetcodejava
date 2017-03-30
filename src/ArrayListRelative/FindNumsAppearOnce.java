package ArrayListRelative;

/**
 * Created by renguifu on 2017/3/11.
 */
public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

        public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            // 利用两个相同的数异或等于0，不为零的话就可以找到出现一次的数
            if(array == null || array.length ==0){
                return;
            }
            // 获得数组之间异或的结果
            int result = 0;
            for(int ele:array){
                result = result ^ ele;
            }
            int location = getFirst1(result);
            // 划分两个子数组，根据某位是否为1，分别对每个子数组进行异或
            for(int i= 0;i <array.length;i++){
                if(isOr1(array[i],location)){
                    num1[0] =num1[0] ^ array[i];
                }else{
                    num2[0] = num2[0] ^ array[i];
                }
            }
        }
        // 找到第一次出现1的位数
        public int getFirst1(int x){
            int index =0;
            int count =0;
            while(count < 32){
                x = x >>> 1;
                index ++;
                if((x & 1)==1){
                    break;
                }
            }
            return index ;
        }
        // 判断某位是否为1
        public boolean isOr1(int x,int location) {
            x = x >>> location;
            return (x & 1) == 1 ? true : false;
        }
}
