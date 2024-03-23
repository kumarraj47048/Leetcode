import java.util.Stack;

class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        
        // Push all nodes onto the stack
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        
        curr = head;
        
        // Reorder the list
        while (true) {
            ListNode last = stack.pop();
            ListNode next = curr.next;
            
            // Mark the current node as visited
            curr.next = last;
            
            if (last == curr) {
                // If the last node is the same as the current one, break the loop
                curr.next = null;
                break;
            }
            
            curr = curr.next;
            
            if (next == last) {
                // If the next node is the same as the last one popped from the stack, break the loop
                curr.next = null;
                break;
            }
            
            curr.next = next;
            curr = curr.next;
        }
    }
}
