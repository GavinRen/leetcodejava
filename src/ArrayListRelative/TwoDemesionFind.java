package ArrayListRelative;

/**
 * Created by renguifu on 2017/1/29.
 */
public class TwoDemesionFind {
    /*
    * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    * 思路： 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行
    * @param matrix 待查找的数组
    * @param number 要查找的数
    * @return 查找结果，true找到，false没有找到
    * */
    public static boolean find(int[][] matrix,int number){
        if(matrix == null || matrix.length < 1 || matrix.length < 1){
            return false;
        }
        int rows = 0;
        int columns = matrix[0].length-1;
        while(rows < matrix.length && columns >= 0){
            if(matrix[rows][columns] == number){
                return true;
            }else if(matrix[rows][columns]> number){
                columns --;
            }else {
                rows ++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(TwoDemesionFind.find(matrix,5));
    }
}
