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
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
       // list.add((long)root.val);
        q.add(null);
        long sum=0;
         //sum=(long)root.val;
        while(q.size()>1){
            TreeNode curr=q.poll();
            if(curr!=null){
                sum+=(long)curr.val;
                if(curr.left!=null)
                q.add(curr.left);
                if(curr.right!=null)
                q.add(curr.right);
            }
            else if(curr==null){
                list.add(sum);
                sum=0;
                q.add(null);
            }
        }
        list.add(sum);
        list.sort(Collections.reverseOrder());
        System.out.print(list);
        if(k>list.size()) return -1;
        return list.get(k-1);
    }
}
