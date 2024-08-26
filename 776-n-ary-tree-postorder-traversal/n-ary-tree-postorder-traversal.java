/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        func(root,list);
        return list;
    }
    public static void func(Node root,List<Integer> list){
        if(root==null) return;
        for(Node temp:root.children){
            func(temp,list);
        }
        list.add(root.val);
    }
}