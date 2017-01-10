package sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renguifu on 2017/1/10.
 * problem:
 * Given four lists A, B, C, D of integer values,
 * compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 */
public class FourSum2 {
    public int fourSumCount(int[] A,int[] B,int[] C,int[] D){
        Map<Integer,Integer> result=new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j = 0;j < B.length;j++){
                int tmp= A[i] +B[j];
                if(result.containsKey(tmp)){
                    result.put(tmp,result.get(tmp)+1);
                }else{
                    result.put(tmp,1);
                }
            }
        }
        int count = 0;
        for(int i = 0; i<C.length;i++){
            for(int j =0;j<D.length;j++){
                if(result.containsKey(C[i]+D[j])){
                    count +=result.get(C[i]+D[j]);
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        FourSum2 fs=new FourSum2();
        int[] A={1,2};
        int[] B={-2,-1};
        int[] C={-1,2};
        int[] D={0,2};
        int result=fs.fourSumCount(A,B,C,D);
        System.out.println(result);
    }
}
