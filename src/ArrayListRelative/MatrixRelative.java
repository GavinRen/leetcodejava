package ArrayListRelative;

import java.util.ArrayList;

/**
 * Created by renguifu on 2017/2/19.
 * 问题：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class MatrixRelative {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null){
            return null;
        }
        int rows = matrix.length;
        if(rows == 0){
            return null;
        }
        int columns = matrix[0].length;
        if(columns == 0){
            return null;
        }
        int start =0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(rows > start * 2 && columns > start *2){
            printMatrixCircle(matrix,start,columns,rows,result);
            start ++;
        }
        return result;
    }
    public void printMatrixCircle(int [][] matrix,int start,int columns,int rows,ArrayList<Integer> result){
        int endx = columns -start - 1;
        int endy = rows -start -1;
        for(int i =start;i<=endx;i++){
            result.add(matrix[start][i]);
        }
        // 从上到下打印一列
        if(start < endy){
            for(int i = start+1;i <= endy;i ++){
                result.add(matrix[i][endx]);
            }
        }
        // 从右到左打印一行
        if(start < endx && start <endy){
            for(int i = endx-1;i>=start;i--){
                result.add(matrix[endy][i]);
            }
        }
        // 从下往上打印
        if(start < endx && start < endy-1){
            for(int i = endy -1;i>=start+1;i--){
                result.add(matrix[i][start]);
            }
        }

    }
}
