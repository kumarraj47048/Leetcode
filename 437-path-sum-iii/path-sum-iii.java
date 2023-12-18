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
    int ct=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        help(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return ct;
    }
   void help(TreeNode root, int k, long currS){
        if(root==null) return;
        currS+=root.val;
        if(currS==k){
            ct++;
            
        }
        help(root.left,k,currS);
        help(root.right,k,currS);
    }
}