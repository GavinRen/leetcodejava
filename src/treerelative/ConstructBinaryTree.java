package treerelative;

import java.util.HashMap;

/**
 * Created by renguifu on 2017/2/4.
 * 问题：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 */
public class ConstructBinaryTree {
    // 思路一：采用递归的思想，前序遍历第一个数字总是树的根节点的值。在中序遍历序列中，根节点的值在序列的中间
    //        左子树的结点的值位于根节点的值的左边，而右子树的结点的值位于根节点的值的右边。这样不断的递归就能重构树
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        return reConstructBinaryTree(pre,0,pre.length -1,in,0,in.length-1);
    }
    private TreeNode reConstructBinaryTree(int [] pre,int startPre, int endPre,int [] in, int startIn,int endIn ){
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i = startIn;i <= endIn;i ++){
            if(in[i] == pre[startPre]){
                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right =reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }
    // 思路：使用hashmap代替了遍历数组
    public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
        if(pre ==null && in ==null){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =0;i < in.length;i++){
            map.put(in[i],i);
        }
        return reConstructBinaryTree2(pre,0,pre.length-1,in,0,in.length-1,map);
    }
    public TreeNode reConstructBinaryTree2(int[] pre,int startPre,int endPre,int[] in, int startIn,int endIn,HashMap<Integer,Integer> map){
        if(startPre > endPre){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        int index = map.get(pre[startPre]);
        root.left = reConstructBinaryTree2(pre,startPre+1,startPre + index - startIn,in ,startIn,index -1,map);
        root.right =reConstructBinaryTree2(pre,startPre + index - startIn+1,endPre,in ,index +1,endIn,map);
        return root;
    }
}
