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
        ArrayList<Integer> list=new ArrayList<>();
       // Collections.fill(list,Integer.MIN_VALUE);
        addRightSideView(root, list, 0);
        //ArrayList<Integer> ans=new ArrayList<>();
        //for(TreeNode i:list) ans.add(i.val);
        return list;
    }
    public static void addRightSideView(TreeNode root, ArrayList<Integer> list, int level){
        if(root==null) return;
        if(list.size()<=level){
            list.add(root.val);
        }
        addRightSideView(root.right,list,level+1);
        addRightSideView(root.left,list,level+1);
    }
}