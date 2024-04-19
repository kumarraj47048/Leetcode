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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        
        Queue<Pair> q=new LinkedList<>();
        if(root!=null)
        q.add(new Pair(root,0));
       // list.get(0).add(root.val);
        while(q.size()>0){
            Pair temp=q.poll();
             int lv=temp.level;

            if(temp!=null && list.size()<lv+1){
                list.add(new ArrayList<>());
            }
            if(root!=null)
            list.get(lv).add(temp.root.val);
            if(temp.root!=null && temp.root.left!=null){
               q.add(new Pair(temp.root.left,lv+1)); 
            }
            if(temp.root!=null && temp.root.right!=null){
                q.add(new Pair(temp.root.right,lv+1));
            }
        }
        return list;
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