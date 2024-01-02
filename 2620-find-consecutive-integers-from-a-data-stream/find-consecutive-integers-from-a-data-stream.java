class DataStream {
    Queue<Integer> qu;
    int value;
    int k;
    public DataStream(int value, int k) {
       
       qu=new LinkedList<>();
        this.value=value;
        //list.add(value);
        this.k=k;
    }
    
    public boolean consec(int num) {
       if(num==value) qu.add(num);
       else qu=new LinkedList<>();
    //    System.gc();
       return qu.size()>=k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */