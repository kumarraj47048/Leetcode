/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean evaluateTree(TreeNode root) {
        return (dfs(root)==1);
    }
    public int dfs(TreeNode root){
       if(root.left==null) return root.val;
       int op=root.val;
       int l=dfs(root.left);
       int r=dfs(root.right);
       if(op==2) return (l|r);
       else return (l&r);
    }
}