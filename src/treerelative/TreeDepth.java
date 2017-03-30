package treerelative;

/**
 * Created by renguifu on 2017/3/11.
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        // 二叉树的深度为左子树的深度和右子树深度的较大值加一，
        if(root == null){
            return 0;
        }
        int nleft = treeDepth(root.left);
        int nright = treeDepth(root.right);
        return nleft > nright ? (nleft+1):(nright+1);
    }
    // 判断是否为平衡二叉树
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root ==null){
            return true;
        }
        // 计算左节点的深度
        int nleft = treeDepth(root.left);
        // 计算右节点的深度
        int mleft = treeDepth(root.right);
        // 判断是否为平衡二叉树
        if(nleft - mleft < -1 || nleft -mleft >1){
            return false;
        }
        // 左右两个节点同时满足不是平衡二叉树，才测试下一节点
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    // 采用后序遍历的方式，只需要遍历一次
    private boolean isBalanced=true;
    public boolean IsBalanced_Solution2(TreeNode root) {

        getDepth(root);
        return isBalanced;
    }
    // 后序方式得到树的深度
    public int getDepth(TreeNode root){
        if(root ==null){
            return 0;
        }
        // 左子树的深度
        int left = getDepth(root.left);
        // 右子树的深度
        int right = getDepth(root.right);
        // 如果两个子树的深度相差不为1，则把平衡标志变为false
        if(Math.abs(left-right) >1){
            isBalanced = false;
        }
        // 返回左子树和右子树深度较大的 加一作为树的深度
        return left > right ? (left +1) : (right +1);
    }
}
