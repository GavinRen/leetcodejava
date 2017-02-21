package byterelative;

/**
 * Created by renguifu on 2017/1/15.
 */
public class ByteRelative {
   //问题：求两个Int型数字之间的汉明距离，也就是把数字转换为二进制数，二进制数之间相对应位置数字不同的个数
   public int hammingDistance(int x,int y){
       int xor = x ^ y;
       int count =0;
       for(int i =0;i < 32; i++){
           count += (xor >> i) & 1;
       }
       return count;
   }
   public int hammingDistance1(int x, int y){
       return Integer.bitCount(x ^ y);
   }
   // 给出32位的整型数据x，返回x的二进制反转之后的结果，
   // 例如 ： 输入：43261596（ 00000010100101000001111010011100）
    //        输出：964176192（00111001011110000010100101000000）
   public int reverseBits(int x){
       int result = 0;
       for(int i=0;i <32; i++){
           result += (x >> i) & 1;
           if (i <31 ){
               result <<= 1;
           }
       }
       return result;
   }
   /*
   * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
   * */
   // 常规解法,位运算与
   public int NumberOf1(int n) {
       int count = 0;
       int flag = 1;
       while(flag != 0){
           if((n & flag) != 0){
               count ++;
           }
           flag =flag << 1;
       }
       return count;
   }
    public int NumberOf1s(int n) {
        int count = 0;
        while(n !=0){
            n = (n-1) & n;
            count ++;
        }
        return count;
    }
   // 判断一个整数是否为2的整数次方
   public static boolean isOrNot2M(int data){
       if(data ==1){
           return false;
       }
       if(((data-1) & data) ==0){
           return true;
       } else {
           return false;
       }
   }
   // 输入两个整数m 和 n,计算需要改变m 的二进制表示中的多少位才能得到n
   public static int changesNums(int m,int n){
       int temp = m ^ n;
       int count =0;
       while(temp !=0){
           count ++;
           temp = (temp - 1)& temp;
       }
       return count;
   }
   public static void main(String[] args){
       ByteRelative br = new ByteRelative();
       System.out.println(ByteRelative.isOrNot2M(5));
       System.out.println(ByteRelative.changesNums(10,13));
       int x =10;
       int y =13;
       System.out.println(br.hammingDistance(x,y));
       System.out.println(br.hammingDistance1(x,y));
//       System.out.println(br.reverseBits(43261596));
   }
}
