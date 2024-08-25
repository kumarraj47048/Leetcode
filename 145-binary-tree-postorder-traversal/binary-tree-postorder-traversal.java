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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        func(list,root);
        return list;
    }
    public static void func(List<Integer> list, TreeNode root ){
        if(root==null) return;
        if(root.left!=null) func(list,root.left);
        if(root.right!=null) func(list,root.right);
        list.add(root.val);
    }
}