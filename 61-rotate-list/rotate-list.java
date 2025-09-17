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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        if(k==0) return head;
        ListNode last=head;
        int size=0;
        while(last.next!=null){
            last=last.next;
            size++;
        }
        size++;

        ListNode fast=head;
        ListNode slow=head;
        for(int i=1;i<=k%size;i++) fast=fast.next;

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        last.next=head;
        ListNode ans=slow.next;
        slow.next=null;
        return ans;
    }
}