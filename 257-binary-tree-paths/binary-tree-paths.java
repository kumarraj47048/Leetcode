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
    public List<String> binaryTreePaths(TreeNode root) {
       ArrayList<String> list=new ArrayList<>();
       help(root,list,"");
       return list;
    }
    public static void help(TreeNode root, ArrayList<String> list, String s){
            if(root==null){
                // s=s+Integer.toString(root.val);
              
                return;
            }
            if(root.left==null && root.right==null){
                s=s+Integer.toString(root.val);
                list.add(s);
            }
            help(root.left,list,s+Integer.toString(root.val)+"->");
             help(root.right,list,s+Integer.toString(root.val)+"->");
    }
}