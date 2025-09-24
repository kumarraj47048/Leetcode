/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ArrayList<ListNode> less=new ArrayList<>();
        ArrayList<ListNode> more=new ArrayList<>();
        ArrayList<ListNode> equal=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x) less.add(curr);
            //else if(curr.val==x) equal.add(curr);
            else more.add(curr);
            
            curr=curr.next;
        }
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        for(int i=0;i<less.size();i++){
            ans.next=less.get(i);
            ans=ans.next;
        }
        // for(int i=0;i<equal.size();i++){
        //     ans.next=equal.get(i);
        //     ans=ans.next;
        // }
        for(int i=0;i<more.size();i++){
            ans.next=more.get(i);
            ans=ans.next;
        }
        ans.next=null;
        return temp.next;
    }
}