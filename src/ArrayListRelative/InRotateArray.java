package ArrayListRelative;

/**
 * Created by renguifu on 2017/2/8.
 * 问题：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 */
public class InRotateArray {
    // 采用顺序查找的方式，时间复杂度为O（n）
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int i = 0;
        while (i < array.length - 1 && array[i + 1] >= array[i]) {
            i++;
        }
        if (i == array.length - 1) {
            return array[i];
        }
        return array[i + 1];
    }

    // 采用二分查找法
    public int minNumberInRotateArray1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int middle = 0;// 如果第一位小于最后一位，说明该序列是递增序列，输出第一位
        while (array[left] >= array[right]) {
            // 循环结束条件
            if (right - left == 1) {
                middle = right;
                break;
            }
            middle = (right + left) / 2;
            // 特例，例如 ： 1，0，1，1，1，无法使用二分查找
            if (array[middle] == array[left] && array[middle] == array[right]) {
                int result = array[left];
                for (int i = left + 1; i <= right; i++) {
                    if (array[i] > result) {
                        result = array[i];
                    }
                }
                return result;
            }
            if (array[middle] >= array[left]) {
                left = middle;
            } else if (array[middle] <= array[left]) {
                right = middle;
            }

        }
        return array[middle];
    }
}
