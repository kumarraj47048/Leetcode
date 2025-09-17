/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        //Node temp=head;
        Node curr=head;
        //Node ans=head;

        while(curr!=null){
            if(curr.child!=null){
                Node nextN=curr.next;
                curr.next=flatten(curr.child);
                curr.next.prev=curr;
                curr.child=null;

                while(curr.next!=null){
                    curr=curr.next;
                }
               
                if(nextN!=null){
                    curr.next=nextN;
                    nextN.prev=curr;
                }
                 
            }

            curr=curr.next;
        }

        return head;
    }
}