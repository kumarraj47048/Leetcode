class MinStack {
    Stack<Integer> st;
    ArrayList<Integer> list;
    public MinStack() {
        st=new Stack<>();
        list=new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if(st.size()==0) st.push(val);
        else if(st.size()>0 && st.peek()>=val) st.push(val);
       // st.push(val);
    }
    
    public void pop() {
        if(st.peek().equals(list.get(list.size()-1))) st.pop();
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return st.peek();
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