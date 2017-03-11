package ArrayListRelative;

/**
 * Created by renguifu on 2017/3/10.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    public long count=0;
    public int InversePairs1(int [] array) {
        if(array==null || array.length<2){
            return 0;
        }
        // 辅助数组
        int[] temp = new int[array.length];
        // 两个指针
        int left =0;
        int right = array.length -1;
        mergeSort(array,temp,left,right);
        return (int)(count % 1000000007) ;
    }
    public void mergeSort(int[] data,int[] temp,int left,int right){
        if(left < right){
            // 找出中间值
            int middle = (left+right) / 2;
            // 分为两个子序列，查看是否有你序列
            mergeSort(data,temp,left,middle);
            // 右子序列
            mergeSort(data,temp,middle+1,right);
            // 对两路子序列进行归并
            merge(data,temp,left,middle+1,right);
        }
    }
    public void merge(int[] data,int[] temp,int left,int rightPox,int right){
        // 左子序列的指针
        int index1=left;
        // 右子序列的指针
        int index2=rightPox;
        // 辅助数组的指针
        int index=0;
        // 合并两个已经排序的序列
        while(index1 < rightPox && index2 <= right){
            // 如果左子序列小于右子序列把左子序列加入到临时数组中
            if(data[index1]<=data[index2]){
                temp[index] = data[index1];
                index ++;
                index1++;
            }else{
                // 当左子序列最小值大于右子子序列时，则加入leftPox-index1个逆序，count++,并把右子序列加入到临时数组
                count = count + (rightPox -index1);
                temp[index] = data[index2];
                index ++;
                index2 ++;
            }
        }
        // 当左子序列还有剩余时，加入到临时数组
        while(index1 < rightPox){
            temp[index] =data[index1];
            index1++;
            index ++;
        }
        // 当右子序列还有剩余时，加入到临时数组
        while(index2 <= right){
            temp[index] = data[index2];
            index2 ++;
            index ++;
        }
        // 临时数组赋值给原始数组
        for(int i =0;i <index ;i++){
            data[left+i] =temp[i];
        }
    }
}
