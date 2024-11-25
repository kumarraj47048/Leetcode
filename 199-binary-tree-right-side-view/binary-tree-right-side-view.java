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
    public List<Integer> rightSideView(TreeNode root) {
       
        List<Integer> list=new ArrayList<>();
         if(root==null) return list;
        func(root,list,1);
        return list;
    }
    public static void func(TreeNode root, List<Integer> list, int level){
      //  if(root==null) return;
        if(list.size()<level) list.add(root.val);
        if(root.right!=null) func(root.right,list,level+1);
        if(root.left!=null) func(root.left,list,level+1);
    }
}