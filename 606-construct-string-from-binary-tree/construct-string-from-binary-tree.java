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
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder("");
        rec(root,sb);
        return sb.toString();
    }

    public static void rec(TreeNode root, StringBuilder  sb){
        if(root==null) return;
        sb.append(root.val);

        if(root.left!=null){
            sb.append("(");
            rec(root.left,sb);
            sb.append(")");
        }
        else{
            if(root.right!=null){
                sb.append("()");
            }
        }

        if(root.right!=null){
            sb.append("(");
            rec(root.right,sb);
            sb.append(")");
        }
    }
}