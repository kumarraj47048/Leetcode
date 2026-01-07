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
    public long max=0;
    public int maxProduct(TreeNode root) {
        int total=tot(root);
        int temp=dfs(root,total);
        int ans=(int)(max%(long)(1e9+7));
        return ans;
    }
    public int tot(TreeNode root){
        int curr=root.val;
        if(root.left!=null) curr+=tot(root.left);
        if(root.right!=null) curr+=tot(root.right);

        return curr;
    }
    public int dfs(TreeNode root, int total){
        int left=0;
        int right=0;
        int curr=root.val;
        
        if(root.left!=null) left=dfs(root.left,total);
        if(root.right!=null) right=dfs(root.right, total);

        curr+=left+right;
          
        if(left!=0)
        max=Math.max(max, (long)(left)*(total-left));
        if(right!=0)
        max=Math.max(max, (long)(right)*(total-right));
        if(curr!=0)
        max=Math.max(max, (long)(curr)*(total-curr));

        return curr;

    }
}
