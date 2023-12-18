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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return check(root,targetSum,0);
    }
    public boolean check(TreeNode root, int k, int sum){
        if(root==null) return false;
        if(root.left==null && root.right==null && sum+root.val==k) return true;
        return (check(root.left,k,sum+root.val) || check(root.right,k,sum+root.val));
    }
}