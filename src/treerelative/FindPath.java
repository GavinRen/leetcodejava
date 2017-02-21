package treerelative;

import java.util.ArrayList;

/**
 * Created by renguifu on 2017/2/21.
 * 问题：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if(root == null){
            return result;
        }
        int sum =0;
        FindPath(root,target,sum,path,result);
        return result;
    }
    public void FindPath(TreeNode root,int target,int sum,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> result ) {
        if (root == null) {
            return;
        }
        sum += root.val;
        // 如果是叶子节点，并且路径上结点的和等于输入的值
        if (root.left == null && root.right == null) {
            if (sum == target) {
                path.add(root.val);
                result.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        // 如果不是叶子节点遍历它的子节点
        FindPath(root.left, target, sum, path, result);
        FindPath(root.right, target, sum, path, result);
        // 在返回父节点之前，在路径上删除当前结点
        path.remove(path.size() - 1);
    }
}
