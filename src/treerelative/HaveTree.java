package treerelative;

/**
 * Created by renguifu on 2017/2/15.
 * 问题：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HaveTree {
    // 先遍历二叉树的根节点，找出与tree2根节点相同的子树，然后再判断子树是否含有tree2树
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = DoesTree1HaveTree2(root1,root2);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }
    public boolean DoesTree1HaveTree2(TreeNode tree1,TreeNode tree2){

        if(tree2 == null){
            return true;
        }
        if(tree1 == null){
            return false;
        }
        if(tree1.val != tree2.val){
            return false;
        }
        return DoesTree1HaveTree2(tree1.left,tree2.left) && DoesTree1HaveTree2(tree1.right,tree2.right);
    }
}
