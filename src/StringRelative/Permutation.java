package StringRelative;

import java.util.ArrayList;

/**
 * Created by renguifu on 2017/2/24.
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        int index =0;
        if(str ==null || str.length() == 0){
            return result;
        }
        char[] strChar = str.toCharArray();
        permutation(strChar,result,index);
        return result;
    }
    public void permutation(char[] strChar, ArrayList<String> result, int index){
        if(index >= strChar.length){
            return;
        }
        for(int i = index;i<strChar.length;i++){
            swap(strChar,i,index);
            if(!result.contains(String.valueOf(strChar))){
                result.add(String.valueOf(strChar));
            }
            permutation(strChar,result,index +1);
            swap(strChar,i,index);
        }
    }
    public void swap(char[] c,int i,int j){
        char temp = c[i];
        c[i] =c[j];
        c[j] = temp;
    }
}
