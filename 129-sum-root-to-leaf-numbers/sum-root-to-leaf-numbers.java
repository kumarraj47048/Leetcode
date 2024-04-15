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
    public int sumNumbers(TreeNode root) {
        return func(root,0);
    }
    public int func(TreeNode root, int curr){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            return curr*10+root.val;
        }
        return func(root.left,curr*10+root.val)+func(root.right,curr*10+root.val);
    }
}