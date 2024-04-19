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
    public int minDepth(TreeNode root) {
        int min=1000000;
        Queue<Pair> q=new LinkedList<>();
        if(root==null) return 0;
        if(root!=null) q.add(new Pair(root,1));
        while(q.size()>0){
            Pair curr=q.poll();
            int lvl=curr.level;
            if(curr.root.left==null && curr.root.right==null){
                min=Math.min(min,lvl);
            }
            if(curr.root.left!=null) q.add(new Pair(curr.root.left,lvl+1));
            if(curr.root.right!=null) q.add(new Pair(curr.root.right,lvl+1));

        }
        return min;
    }
}
class Pair{
    TreeNode root;
    int level;
    Pair(TreeNode root, int level){
        this.root=root;
        this.level=level;
    }
}