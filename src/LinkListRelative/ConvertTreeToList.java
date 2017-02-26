package LinkListRelative;

import treerelative.TreeNode;

import java.util.Stack;

/**
 * Created by renguifu on 2017/2/23.
 */
public class ConvertTreeToList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNode = null;
        TreeNode pHead =Convert(pRootOfTree,lastNode);
        while(pHead != null && pHead.left !=null){
            pHead =pHead.left;
        }
        return pHead;
    }
    public TreeNode Convert(TreeNode pRootOfTree,TreeNode lastNode){
        if(pRootOfTree == null){
            return null;
        }
        TreeNode current = pRootOfTree;
        if(current.left != null){
            lastNode = Convert(current.left,lastNode);
        }
        current.left = lastNode;
        if(lastNode != null){
            lastNode.right = current;
        }
        lastNode = current;
        if(current.right !=null){
            lastNode= Convert(current.right,lastNode);
        }
        return lastNode;
    }
    // 采用非递归的方式
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree ==null){
            return null;
        }
        TreeNode treeNode = pRootOfTree;
        TreeNode head =null;
        TreeNode pre =null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean flag = true;
        while(treeNode !=null || !stack.isEmpty()){
            while(treeNode !=null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            if(flag){
                head = treeNode;
                pre = treeNode;
                flag =false;
            }else{
                pre.right = treeNode;
                treeNode.left = pre;
                pre = treeNode;
            }
            treeNode = treeNode.right;
        }
        return head;
    }
}
