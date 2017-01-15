package StringRelative;

/**
 * Created by renguifu on 2017/1/15.
 */
public class StringRelative {
//   字符串反转，
    public String reverseString(String s){
        int len =s.length();
        char[] tmp = new char[len];
        for(int i =len-1;i >=0; i --){
            tmp[len-1-i] = s.charAt(i);
        }
        return new String(tmp);
    }
    public String reverseString1(String s){
        StringBuilder tmp = new StringBuilder(s);
        return tmp.reverse().toString();
    }
    public static void main(String[] args){
        StringRelative sr = new StringRelative();
        System.out.println(sr.reverseString("hellow"));
        System.out.println(sr.reverseString1("hellow"));
    }
}
