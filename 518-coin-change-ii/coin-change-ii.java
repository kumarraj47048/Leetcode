class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int[5001][301];
        for(int i=0;i<=5000;i++) Arrays.fill(dp[i],-1);
        return solve(amount,0,0,coins,dp);
    }
    public static int solve(int amount,int current,int idx, int coins[], int dp[][]){
        if(amount==current) return 1;
        if(amount<current) return 0;
        if(dp[current][idx]!=-1) return dp[current][idx];
        int n=coins.length;
        int res=0;
        for(int i=idx;i<n;i++){
            res+=solve(amount,current+coins[i],i,coins,dp);
        }
        return dp[current][idx]=res;
    }
}