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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return helpFunc(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helpFunc(TreeNode root,long a, long b){
           if(root==null) return true;
           if(root.val<=a || root.val>=b) return false;
           return (helpFunc(root.left,a,root.val) && helpFunc(root.right,root.val,b));
    }
}