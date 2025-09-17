class BrowserHistory {
    Node head;
    public BrowserHistory(String homepage) {
        head=new Node(homepage);
    }
    
    public void visit(String url) {
        head.next=new Node(url);
        head.next.prev=head;
        head=head.next;
        head.next=null;
    }
    
    public String back(int steps) {
        
        while(head.prev!=null && steps-->0){
            head=head.prev;
        }
        return head.val;
    }
    
    public String forward(int steps) {
        while(head.next!=null && steps-->0){
            head=head.next;
        }
        return head.val;
    }
}
class Node{
    String val;
    Node prev;
    Node next;
    Node(String val){
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */