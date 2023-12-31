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
    public int averageOfSubtree(TreeNode root) {
        int res[]=new int[1];
        traverse(root,res);
        return res[0];
    }

    public static int[] traverse(TreeNode node, int res[]){
        if(node==null) return new int[]{0,0};
        int left[]= traverse(node.left, res);
        int right[]= traverse(node.right,res);

        int currSum= node.val + left[0] + right[0];
        int currCount= 1 + left[1] + right[1];

        if(currSum / currCount == node.val) res[0]++;

        return new int[]{ currSum, currCount};
    }
}