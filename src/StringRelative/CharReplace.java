package StringRelative;

/**
 * Created by renguifu on 2017/2/2.
 */
public class CharReplace {
    public String replaceSpace(StringBuffer str){
        StringBuilder result = new StringBuilder();
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)==' '){
                result.append("%20");
            }else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
    public String replaceSpace1(StringBuffer str){
        for(int i=0;i<str.length();i ++){
            if(str.charAt(i)==' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
    public static void main(String[] args){
        String str ="Hello world  !";
        System.out.println(new CharReplace().replaceSpace(new StringBuffer(str)));
        System.out.println(new CharReplace().replaceSpace1(new StringBuffer(str)));
        System.out.println(str.replaceAll("\\s","%20"));
    }
}
