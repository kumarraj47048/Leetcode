/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return func(root,p,q);
    }
    public TreeNode func(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if((root==p) || (root==q)) return root;
        TreeNode leftFunc=func(root.left,p,q);
        TreeNode rightFunc=func(root.right,p,q);
        if(leftFunc==p && rightFunc==q) return root;
        if(rightFunc==p && leftFunc==q) return root;
        if(leftFunc!=null && rightFunc==null) return leftFunc;
        if(leftFunc==null && rightFunc!=null) return rightFunc;
        return null;
    }
}