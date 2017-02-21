package treerelative;

/**
 * Created by renguifu on 2017/2/21.
 * 问题：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class SquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length ==0){
            return false;
        }
        int len = sequence.length-1;
        return VerifySquenceOfBST(sequence,0,len);
    }
    public boolean VerifySquenceOfBST(int [] sequence,int start ,int end){
        if(sequence == null){
            return false;
        }
        int root = sequence[end];
        int leftIndex = end;
        for(int i = end; i >= start;i -- ){
            if(sequence[i]< root){
                leftIndex = i;
                break;
            }
        }
        if(leftIndex <end){
            for(int i = start; i< leftIndex;i ++){
                if(sequence[i]>root){
                    return false;
                }
            }
        }
        boolean left = true;
        if(leftIndex < end){
            left = VerifySquenceOfBST(sequence,0,leftIndex);
        }
        boolean right = true;
        if(leftIndex < end -1){
            right = VerifySquenceOfBST(sequence,leftIndex+1,end -1);
        }
        if(left && right){
            return true;
        }else {
            return false;
        }
    }
}
