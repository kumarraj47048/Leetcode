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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int sz=stack.size()/2;
       // for(int i=0;i<stack.size();i++) System.out.println(stack.pop().val);
        for(int i=0;i<sz;i++){
            if(head.val!=stack.pop().val) return false;
            head=head.next;
        }
        return true;
    }
}