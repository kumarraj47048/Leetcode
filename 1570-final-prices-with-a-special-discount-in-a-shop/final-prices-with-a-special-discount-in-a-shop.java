class Solution {
    public int[] finalPrices(int[] prices) {
       int n=prices.length;
       int ans[]=new int[n];
       for(int i=0;i<n;i++){
          int idx=i+1;
          ans[i]=prices[i];
          while(idx<n){
            if(prices[i]<prices[idx])
            idx++;
            else break;
          }
          if(idx<n) ans[i]-=prices[idx];
       } 
       return ans;
    }
}