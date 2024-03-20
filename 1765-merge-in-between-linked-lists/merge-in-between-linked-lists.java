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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp=list1;
        for(int i=1;i<=a-1;i++){
              temp=temp.next;
        }
        ListNode temp2=temp;
        for(int i=1;i<=b-a+2;i++){
            temp2=temp2.next;
        }
        temp.next=list2;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=temp2;

        return list1;
    }
}