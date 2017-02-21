package StringRelative;

/**
 * String 、StringBuffer和StringBuilder之间性能的比较
 * Created by renguifu on 2017/2/2.
 */
public class StringCompare {
    private final int Loop_TIMES = 200000;
    private final String CONSTANT_SRING = "Hello String";
    public void testString(){
        String string = "";
        Long begin = System.currentTimeMillis();
        for(int i =0; i < Loop_TIMES;i++){
            string += CONSTANT_SRING;
        }
        Long end = System.currentTimeMillis();
        System.out.println("String:"+(end - begin)+"\t");
    }
    public void testStringBuilder(){
        StringBuilder builder = new StringBuilder();
        Long begin = System.currentTimeMillis();
        for (int i = 0; i < Loop_TIMES; i++) {
            builder.append(CONSTANT_SRING);
        }
        Long end = System.currentTimeMillis();
        System.out.println("StringBuilder:"+(end - begin)+"\t");
    }
    public void testStringBuffer(){
        StringBuffer buffer = new StringBuffer();
        Long begin = System.currentTimeMillis();
        for(int i =0 ;i< Loop_TIMES;i++){
            buffer.append(CONSTANT_SRING);

        }
        Long end = System.currentTimeMillis();
        System.out.println("StringBuffer:"+(end - begin)+"\t");
    }
    public void startTest(){
        for (int i = 0; i < 6; i++) {
            System.out.println("the is " +i +"test [");
            testString();
            testStringBuilder();
            testStringBuffer();
            System.out.println("\t ]");
        }
    }
    public static void main(String[] args){
//        new StringCompare().startTest();
        String str1 ="Hello world";
        String str2 ="Hello world";
        String str3 =new String("Hello world");
        String str4 =new String("Hello world");
        System.out.println(str1==str2);
        System.out.println(str3==str4);
        System.out.println(str3.equals(str4));
        System.out.println(str3.hashCode()==str4.hashCode());
        str2.replace(' ','%');
    }
}
