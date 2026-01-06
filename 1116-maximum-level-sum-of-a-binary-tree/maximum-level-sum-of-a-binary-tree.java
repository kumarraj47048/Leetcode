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
    public int maxLevelSum(TreeNode root) {
        int lvl=0;
        Queue<TreeNode> q=new LinkedList<>();
        int max=root.val;
        int curr=root.val;
        q.add(root);
        //lvl[1]+=root.val;
        int ans=1;
        while(q.size()>0){
            lvl++;
            int sz=q.size();
            curr=0;
            for(int i=0;i<sz;i++){
                TreeNode x=q.poll();
                curr+=x.val;
                if(x.left!=null) q.add(x.left);
                if(x.right!=null) q.add(x.right);
            }
            if(curr>max){
                ans=lvl;
                max=curr;
            }
        }

        return ans;
    }
}
