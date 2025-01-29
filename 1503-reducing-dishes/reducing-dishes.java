class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        Arrays.sort(satisfaction);
        long dp[][]=new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        // for time equals to zero, sum will be 0

        for(int i=0;i<=n;i++) dp[i][0]=0;
        
        for(int j=1;j<=n;j++){
            for(int i=1;i<=n;i++){
                long take=satisfaction[i-1]*j+dp[i-1][j-1];
                long not_take=dp[i-1][j];
                dp[i][j]=Math.max(take,not_take);
            }
        }
        long max=0;
        for(int i=1;i<=n;i++) max=Math.max(max,dp[n][i]);
        return (int)max;
    }
}