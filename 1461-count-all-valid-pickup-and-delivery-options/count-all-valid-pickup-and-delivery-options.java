class Solution {
    public int countOrders(int n) {
        long ct=1;
        for(int i=2*n;i>=1;i-=2){
            ct=((ct)*((i*(i-1))/2))%1000000007;
        }
        return (int)ct;
    }
    
   
}