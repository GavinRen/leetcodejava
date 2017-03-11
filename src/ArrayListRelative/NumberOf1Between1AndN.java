package ArrayListRelative;

/**
 * Created by renguifu on 2017/3/9.
 * 问题：
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0){
            return 0;
        }
        int count =0;
        while(n >0){
            String str =String.valueOf(n);
            char[] chs = str.toCharArray();
            for(char ch : chs){
                if(ch =='1'){
                    count++;

                }
            }
            n--;
        }
        return count;
    }
    public int NumberOf1Between1AndN_Solution1(int n) {
        if(n < 0){
            return 0;
        }
        // 取最高位
        String str = String.valueOf(n);
        int index = str.length();
        if(index ==1 && n ==0){
            return 0;
        }
        if(index ==1 && n >0){
            return 1;
        }
        int numsOfTen = (int)Math.pow(10,index-1);
        int first = n / numsOfTen ;
        // 最高位为1时的数量
        int numFirstDigit = 0;
        if(first >1){
            numFirstDigit = (int)Math.pow(10,index-1);
        }else{
            numFirstDigit = n - numsOfTen + 1;
        }
        // 除了最高位其它位上1的数量
        int numOtherDigit = first * (index-1) * (int)Math.pow(10,index-2);
        // 递归到比它小的数字
        int numRecursive = NumberOf1Between1AndN_Solution(n % numsOfTen);
        return numFirstDigit + numOtherDigit + numRecursive;

    }
}
