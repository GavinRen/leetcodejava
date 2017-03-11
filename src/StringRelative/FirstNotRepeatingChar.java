package StringRelative;

import java.util.HashMap;
/**
 * Created by renguifu on 2017/3/9.
 * 在一个字符串(1<=字符串长度<=10000，
 * 全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeating(String str) {
        if(str == null){
            return -1;
        }
        HashMap<Character,Integer> hash = new HashMap<>();
        char[] array = str.toCharArray();
        for(int i=0;i<array.length;i++){
            if(!hash.containsKey(array[i])){
                hash.put(array[i],1);
            }else{
                hash.put(array[i],hash.get(array[i])+1);
            }
        }
        for(int i=0;i<array.length;i++){
            if(hash.get(array[i])==1){
                return i;
            }
        }
        return -1;
    }
}
