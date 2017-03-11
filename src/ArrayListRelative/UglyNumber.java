package ArrayListRelative;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renguifu on 2017/3/9.
 */
public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if(index <1){
            return 0;
        }
        // 存放丑数的数组
        List<Integer> list = new ArrayList<Integer>();
        //定义指向2的倍数，3的倍数，5的倍数的位置
        int p2 =0;
        int p3 =0;
        int p5 =0;
        list.add(1);
        while(list.size() < index){
            int ugly2= list.get(p2)*2;
            int ugly3= list.get(p3)*3;
            int ugly5= list.get(p5)*5;
            // 取最小的数作为丑数添加进去
            int min =Math.min(ugly2,Math.min(ugly3,ugly5));
            list.add(min);
            if(min == ugly2){
                p2++;
            }
            if(min == ugly3){
                p3++;
            }
            if(min == ugly5){
                p5++;
            }
        }
        return list.get(index-1);
    }
}
