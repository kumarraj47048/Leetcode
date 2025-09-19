class StockSpanner {
    ArrayList<Integer> list;
    Stack<Integer> st;
    int idx;
    public StockSpanner() {
        list=new ArrayList<>();
        st=new Stack<>();
        idx=0;
    }
    
    public int next(int price) {
        list.add(price);
        while(st.size()>0 && list.get(st.peek())<=price) st.pop();
        int count=0;
        if(st.size()==0){
            count= idx+1;
        }
        else {
            count=idx-st.peek();
        }
        st.push(idx);
        idx++;
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */