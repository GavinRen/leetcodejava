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
   public static void main(String[] args){
       ByteRelative br = new ByteRelative();
       int x =10;
       int y =13;
       System.out.println(br.hammingDistance(x,y));
       System.out.println(br.hammingDistance1(x,y));
       System.out.println(br.reverseBits(43261596));
   }
}
