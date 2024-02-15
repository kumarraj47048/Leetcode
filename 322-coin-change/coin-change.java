class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[]=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        if(amount==0) return 0;
        if(solveTab(coins,amount)==Integer.MIN_VALUE || solveTab(coins,amount)==Integer.MAX_VALUE) return -1;
        else return solveTab(coins,amount);
    }

    public int solveTab(int coins[],int amt){
        int n=coins.length;
        int dp[]=new int[amt+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=amt;i++){
            for(int j=0;j<n;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        return dp[amt];
    }
     public int solveMem(int coins[],int amt,int dp[]){
        int n=coins.length;
        if(amt<0) return Integer.MAX_VALUE;
        if(amt==0) return 0;
        if(dp[amt]!=Integer.MAX_VALUE) return dp[amt];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans, solveMem(coins,amt-coins[i],dp));
            dp[amt]=ans;
        }
        if(ans==Integer.MAX_VALUE ) return dp[amt]=-1;
        else return dp[amt]=ans+1;
    }

    public int solve(int coins[],int amt){
        int n=coins.length;
        if(amt<0) return Integer.MAX_VALUE;
        if(amt==0) return 0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans, solve(coins,amt-coins[i]));
        }
        if(ans==Integer.MAX_VALUE ) return -1;
        else return ans+1;
    }
}