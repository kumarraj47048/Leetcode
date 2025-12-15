class Solution {
    public long getDescentPeriods(int[] prices) {
        int n=prices.length;
        long dp[]=new long[n];
        Arrays.fill(dp,1);
        //dp[0]=0;
        long sum=1;
        for(int i=1;i<n;i++){
            int x=prices[i];
                if(prices[i-1]-1==x) dp[i]+=dp[i-1];
            sum+=dp[i];
        }
         
        for(long i:dp) System.out.println(i);

        return sum;
    }
}