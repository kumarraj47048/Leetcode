/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         List<List<Node>> list=new ArrayList<>();
        
        Queue<Pair> q=new LinkedList<>();
        if(root!=null)
        q.add(new Pair(root,0));
       // list.get(0).add(root.val);
        while(q.size()>0){
            Pair temp=q.poll();
             int lv=temp.level;

            if(list.size()<lv+1){
                list.add(new ArrayList<>());
            }
            if(root!=null)
            list.get(lv).add(temp.root);
            if(temp.root!=null && temp.root.left!=null){
               q.add(new Pair(temp.root.left,lv+1)); 
            }
            if(temp.root!=null && temp.root.right!=null){
                q.add(new Pair(temp.root.right,lv+1));
            }
        }

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                if(j<list.get(i).size()-1){
                    Node temp=list.get(i).get(j);
                    temp.next=list.get(i).get(j+1);
                }
                else{
                     Node temp=list.get(i).get(j);
                     temp.next=null;
                }
            }
            //System.out.println();
        }
        return root;
    }
}


class Pair{
    Node root;
    int level;
    Pair(Node root, int level){
        this.root=root;
        this.level=level;
    }
}