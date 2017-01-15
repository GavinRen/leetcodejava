/**
 * Created by renguifu on 2017/1/12.
 */
public class Test {
    public static void main(String[] args) {
        int x = 11;
        int y = 15;
        System.out.println((byte)11);
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(x >> 1);
        System.out.println(x ^ y);
        System.out.println(Integer.bitCount(x ^ y));
        int count=0;
        int xor =x ^ y;
        for (int i =0;i<32;i++){
            count += (xor >> i) & 1;
        }
        System.out.println(count);
    }
}
