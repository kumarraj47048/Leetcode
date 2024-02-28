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
    int ans=0;
    public int findBottomLeftValue(TreeNode root) {

        boolean check[]=new boolean[10001];
       
        func(root,check,0);
        return ans;
    }
    public void func(TreeNode root, boolean check[],int level){
        if(root==null) return;
         if(check[level]==false){
            ans=root.val;
            check[level]=true;
        }
        func(root.left,check,level+1);
        
        func(root.right,check,level+1);
       
    }
}