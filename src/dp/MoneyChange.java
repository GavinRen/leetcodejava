package dp;

/**
 * Created by renguifu on 2017/3/27.
 * 采用动态规划方法解决找零问题，
 * 找零问题：给出一个数额，求最小的找零问题
 * 把一个大问题，变成一个小问题，只是范围变了，其他并没有变
 * 使用额外的存储空间，用来存储中间结果
 */
public class MoneyChange {
    public static int moneyChage(int money,int[] coin,int[] temp){
        for(int i =0;i<= money;i++){
            int minCoins = i/temp[temp.length-1];
            for(int j=0;j<coin.length;j++){
                if(coin[j]<=i){
                    int tempCoins = temp[i-coin[j]]+1;
                    if(tempCoins<minCoins){
                        minCoins=tempCoins
                    }

                }
            }
        }
    }
}
