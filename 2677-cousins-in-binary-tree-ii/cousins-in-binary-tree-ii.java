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
    public TreeNode replaceValueInTree(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int sz=q.size();
            int sum=0;
            for(int i=0;i<sz;i++){
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            list.add(sum);
        }
        System.out.println(list);
        q.add(root);
        root.val=0;
        int idx=1;
        while(q.size()>0){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                TreeNode curr=q.poll();
                int sum=0;
                if(curr.left!=null){
                    sum+=curr.left.val;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    sum+=curr.right.val;
                    q.add(curr.right);
                }

                if(curr.left!=null){
                    curr.left.val=list.get(idx)-sum;
                }
                 if(curr.right!=null){
                    curr.right.val=list.get(idx)-sum;
                }

            }
            idx++;
        }
        return root;
    }
}