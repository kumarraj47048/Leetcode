class Solution {
    public int minCostClimbingStairs(int[] cost) {
    //     int dp[]=new int[cost.length+2];
    //     Arrays.fill(dp,Integer.MAX_VALUE);
    //    // return Math.min(solve(cost,0,dp), solve(cost,1,dp));
       return solveTab(cost);
    }
     public int solveTab(int cost[]){
        int n=cost.length;
        int dp[]=new int[cost.length+2];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
    public int solve(int cost[], int i, int dp[]){
        if(i>=cost.length) return 0;
        if(i==cost.length-1) return cost[i];
        if(dp[i]!=Integer.MAX_VALUE) return dp[i];
        return dp[i]=cost[i]+Math.min(solve(cost,i+1,dp), solve(cost,i+2,dp));
    }
}