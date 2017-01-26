package treerelative;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by renguifu on 2017/1/15.
 */
public class TreeRelative {
    /*问题：输入：beginWord ,endWord ，dictionary's word list
    *       输出： 一次改变一个字符，beginword 转换到 endWord ，最短队列的长度，中间字符串在字典里
    * 解决方法：采用宽度搜索的思想
    *
    * */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList){
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len =1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> temp =endSet;
                endSet = beginSet;
                beginSet = temp;
            }
            Set<String> tempSet = new HashSet<>();
            for(String word :beginSet){
                char[] wordChar = word.toCharArray();
                for(int i =0; i < wordChar.length; i ++){
                    for(char a = 'a'; a <= 'z'; a ++){
                        char old = wordChar[i];
                        wordChar[i] = a;
                        String newString = String.valueOf(wordChar);
                        if(endSet.contains(newString)){
                            return len + 1 ;
                        }
                        if(!visited.contains(newString) && wordList.contains(newString)){
                            tempSet.add(newString);
                            visited.add(newString);
                        }
                        wordChar[i] =old;
                    }
                }
            }
            len ++;
            beginSet = tempSet;
        }
        return  0;
    }
    public static void main(String[] args){
        TreeRelative tr = new TreeRelative();
        Set<String> wordList =new HashSet<>();
        String[] wordArray ={"hot","dot","dog","lot","log"};
        for(String word :wordArray){
            wordList.add(word);
        }
        System.out.println(tr.ladderLength("hit","cog",wordList));
        char a = 'a';
        System.out.println(a);
        System.out.println(a +1);
        char b = (char) (a +1);
        System.out.println(b);
        for(char c ='a';c<='z';c ++){
            System.out.println(c);
        }

    }
}
