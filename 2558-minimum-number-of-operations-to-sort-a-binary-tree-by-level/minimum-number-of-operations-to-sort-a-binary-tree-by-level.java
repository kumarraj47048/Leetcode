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
    public int minimumOperations(TreeNode root) {
        int min=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int sz=q.size();
            int arr[]=new int[sz];
            for(int i=0;i<sz;i++){
                TreeNode curr=q.poll();
                arr[i]=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            
            for(int i=0;i<sz-1;i++){
                int minIdx=i;
                for(int j=i+1;j<sz;j++){
                    if(arr[minIdx]>arr[j]) minIdx=j;
                }
                if(minIdx!=i){
                    min++;
                    int temp=arr[i];
                    arr[i]=arr[minIdx];
                    arr[minIdx]=temp;
                }
            }
        }
        return min;
    }
}