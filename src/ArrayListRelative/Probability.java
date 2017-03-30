package ArrayListRelative;

/**
 * Created by renguifu on 2017/3/12.
 *
 */
public class Probability {
    public void printProbability(int number){
        if(number < 1){
            return;
        }
        // 和的最大值
        int maxSum = 6*number;
        // 和的最小值
        int minSum = number;
        // 数组用来存放和出现的次数
        int[] result = new int[maxSum-minSum+1];
        // 初始化当前和的值为0
        int curSum =0;
        for (int i = 1; i <=6; i++) {
            probability(minSum,i,number - 1,result);
        }

        for(int i =0;i<result.length;i++){
            System.out.println((minSum+i)+"\t"+result[i]);
        }
    }
    public void probability(int minSum,int curSum,int number1,int[] array){
        if(number1==0){
//            System.out.println(curSum-minSum);
            array[curSum - minSum]++;
        }else{
            for (int i =1;i<=6;i++){

//                number1--;
                probability(minSum,curSum + i,number1 - 1,array);
            }
        }
    }

    public static void main(String[] args) {
        new Probability().printProbability(3);
    }
}
