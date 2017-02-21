package treerelative;

import java.util.Stack;

/**
 * Created by renguifu on 2017/2/18.
 * 问题：操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class TreeMirror {
    // 采用递归的方式
    public void Mirror(TreeNode root) {
        if(root == null ){
            return ;
        }
        if(root.left == null && root.right == null){
            return ;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
    // 采用非递归的方式，使用堆栈的思想
    public void Mirror1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null){
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node.left !=null || node.right !=null){
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
    }

}
