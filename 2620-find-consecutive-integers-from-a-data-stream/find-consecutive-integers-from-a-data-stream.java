class DataStream {
    int ct=0;
    int value;
    int k;
    public DataStream(int value, int k) {
       
        ct=0;
        this.value=value;
        //list.add(value);
        this.k=k;
    }
    
    public boolean consec(int num) {
       if(num==value) ct++;
       else ct=0;
      //System.gc();
       return ct>=k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */