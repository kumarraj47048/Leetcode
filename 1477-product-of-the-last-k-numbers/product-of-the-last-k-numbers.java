class ProductOfNumbers {
    ArrayList<Integer> list;
    public ProductOfNumbers() {
        list=new ArrayList<>();
       
    }
    
    public void add(int num) {
       
        list.add(num);
    }
    
    public int getProduct(int k) {
        int temp=1;
        int n=list.size();
        for(int i=n-1;i>=n-k;i--) temp*=list.get(i);
        return temp;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */