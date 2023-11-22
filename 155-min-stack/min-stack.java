class MinStack {
    Stack<Integer> s;
    Stack<Integer> ans;
    public MinStack() {
        s=new Stack<>();
        ans=new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(ans.size()!=0)
        ans.push(Math.min(val,ans.peek()));
        else ans.push(val);
    }
    
    public void pop() {
        s.pop();
        ans.pop();
    }
    
    public int top() {
     return s.peek();   
    }
    
    public int getMin() {
        return ans.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */