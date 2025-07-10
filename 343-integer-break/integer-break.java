class Solution {
   // int max=1;
    public int integerBreak(int n) {
       int dp[]=new int[60];
       Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n, int dp[]){
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int temp=1;
        for(int i=1;i<=n-1;i++){
            int x=i*(Math.max(n-i,solve(n-i,dp)));
            temp=Math.max(temp, x);
        }
        return dp[n]=temp;
    }
}