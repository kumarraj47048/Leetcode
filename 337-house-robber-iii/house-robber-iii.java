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
    HashMap<String,Integer> map=new HashMap<>();
    public int rob(TreeNode root) {
        return solve(root,true);
    }
    public int solve(TreeNode root, boolean can_rob){
        String key=root.hashCode()+","+can_rob;
        if(map.containsKey(key)) return map.get(key);
        int take=0;
        int not_take=0;
        if(root.left!=null){
            take+=solve(root.left,false);
            not_take+=solve(root.left,true);
        }
        if(root.right!=null){
            take+=solve(root.right,false);
            not_take+=solve(root.right,true);
        }

        if(can_rob){
            take+=root.val;
        }
        map.put(key,Math.max(take,not_take));
        return Math.max(take,not_take);
        
    }
}