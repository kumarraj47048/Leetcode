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
class FindElements {
    private TreeNode tree;
    public FindElements(TreeNode root) {
        tree=root;
        Queue<TreeNode> q=new LinkedList<>();
        tree.val=0;
        q.add(tree);
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<q.size();i++){
                TreeNode curr=q.poll();
                System.out.println(curr.val);
                if(curr.left!=null){
                    curr.left.val=2*curr.val+1;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    curr.right.val=2*curr.val+2;
                    q.add(curr.right);
                }
            }
        }
    }
    
    public boolean find(int target) {
        return dfs(tree,target);
    }
    public static boolean dfs(TreeNode root, int target){
        if(root==null) return false;
        if(root.val==target) return true;
        boolean check=false;
        if(root.left!=null && dfs(root.left,target)) check=true;
        if(root.right!=null && dfs(root.right,target)) check=true;
        return check;
    }
}

// class TreeNode{
//     int data;
//     TreeNode left,right;
//     TreeNode(int data){
//         this.data=data;
//         this.left=null;
//         this.right=null;
//     }
// }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */