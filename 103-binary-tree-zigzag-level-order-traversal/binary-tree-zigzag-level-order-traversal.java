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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        if(root!=null)
        q.add(new Pair(root,0));
        while(q.size()>0){
            Pair curr=q.poll();
            int lvl=curr.level;
            if(list.size()<lvl+1){
                list.add(new ArrayList<>());
            }
            if(curr.root!=null)
            list.get(lvl).add(curr.root.val);
            if(curr.root!=null && curr.root.left!=null){
                q.add(new Pair(curr.root.left,lvl+1));
            }
            if(curr.root!=null && curr.root.right!=null){
                q.add(new Pair(curr.root.right,lvl+1));
            }
        }

        for(int i=1;i<list.size();i+=2){
            Collections.reverse(list.get(i));
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