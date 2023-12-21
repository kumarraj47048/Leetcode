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
    //   static  ArrayList<TreeNode> list1=new ArrayList<>();
    //    static  ArrayList<TreeNode> list2=new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
          ArrayList<TreeNode> list1=new ArrayList<>();
        ArrayList<TreeNode> list2=new ArrayList<>();
       help(root1,list1); 
       help2(root2,list2);
       for(TreeNode v:list1) System.out.print(v.val+" ");
       System.out.println();
       for(TreeNode v: list2) System.out.print(v.val+" ");
       if(list1.size()!=list2.size()) return false;
       for(int i=0;i<list1.size();i++){
           if(list1.get(i).val!=list2.get(i).val) return false;
       }
       return true;
    }
    public static void help(TreeNode root, ArrayList<TreeNode> list1){
             if(root==null) return;
             help(root.left,list1);
             if(root.left==null && root.right==null) list1.add(root);
             help(root.right,list1);
    }

    public static void help2(TreeNode root, ArrayList<TreeNode> list2){
             if(root==null) return;
             help(root.left,list2);
             if(root.left==null && root.right==null) list2.add(root);
             help(root.right, list2);
    }
}