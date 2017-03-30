package SortRelative;

/**
 * Created by renguifu on 2017/3/21.
 */
public class HeapSort {
    // 快速排序，首先理解一个前提如果把二叉树存到数组，一个节点的小标为i,则它的左节点为2*i+1,右节点为2*i+2
    public void heapSort(int[] array){
        if(array == null || array.length==0){
            return ;
        }
        // 每一次建完堆，让最大值与最后一个值进行交换，然后继续建堆，直到堆为零
        for(int i = 0;i<array.length;i++){
            createHeap(array,array.length-1-i);
            swap(array,0,array.length-1-i);
        }
    }
    public void createHeap(int[] array,int index){
        // 从后遍历节点和它对应的左节点和右节点
        for(int i = (index -1)/2;i>=0;i--){
            // 当前结点
            int k =i;
            while((2*k+1)<= index){
                // 把左节点当做做稍微大的结点
                int bigIndex = 2*k+1;
                if(bigIndex<index){
                    // 如果右节点存在则比较左右结点取较大的作为bigindex
                    if(array[bigIndex]<array[bigIndex+1]){
                        bigIndex++;
                    }
                }
                // 如果根节点小于自己则交换，
                if(array[k]<array[bigIndex]){
                    swap(array,k,bigIndex);
                    k = bigIndex;
                }else {
                    break;
                }
            }
        }
    }
    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        HeapSort hs = new HeapSort();
        hs.heapSort(data5);
        for(int data:data5){
            System.out.println(data);
        }
    }
}
