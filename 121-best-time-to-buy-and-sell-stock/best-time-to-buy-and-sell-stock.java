class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sf[]=new int[n];
        sf[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            sf[i]=Math.max(prices[i],sf[i+1]);
        }
        int max=0;
        for(int i=0;i<n-1;i++){
            max=Math.max(max,sf[i]-prices[i]);
        }
        return max;
    }
}