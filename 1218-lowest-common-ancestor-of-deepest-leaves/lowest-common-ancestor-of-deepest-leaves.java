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
    int d;
    TreeNode lca;
    int maxD;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        d=0;
        maxD=0;
        lca=root;
        helper(root,d);
        return lca;
    }
    private int helper(TreeNode root, int d){
        maxD=Math.max(maxD,d);
        if(root==null) return d;
        
        int left=helper(root.left,d+1);
        int right=helper(root.right,d+1);

        if(left==maxD && right==maxD){
            lca=root;
        }
        return Math.max(left,right);
    }
}
