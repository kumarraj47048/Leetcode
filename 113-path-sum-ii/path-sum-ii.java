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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
       func(root,targetSum,0,ans,new ArrayList<Integer>());
       return ans;
    }
    public static void func(TreeNode root, int k, int sum, List<List<Integer>> ans, ArrayList<Integer> in ){
        if(root==null) return;
        ArrayList<Integer> m=new ArrayList<>(in);
        m.add(root.val);
        if(root.left==null && root.right==null && sum+root.val==k){
           
            ans.add(m);
            return;
        }
       
        func(root.left,k,sum+root.val,ans,m);
        func(root.right,k,sum+root.val,ans,m);
    }
}