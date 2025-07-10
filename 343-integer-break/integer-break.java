class Solution {
    int max=1;
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int dp[]=new int[60];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n, int dp[]){
        
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        int temp=1;
        for(int i=1;i<=n;i++){
            if(n-i>=0)
            temp=Math.max(temp, (i)*(solve(n-i,dp)));
        }
        return dp[n]=temp;
    }
}