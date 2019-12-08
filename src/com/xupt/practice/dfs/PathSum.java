package com.xupt.practice.dfs;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    boolean flag=false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return flag;
        }
        dfs(root,sum);
        return flag;
    }
    private void dfs(TreeNode node,int sum){
        if(node==null){
            return;
        }
        if(node.left==null&&node.right==null&&node.val==sum){
            flag=true;
        }
        dfs(node.left,sum-node.val);
        dfs(node.right,sum-node.val);
    }
}
