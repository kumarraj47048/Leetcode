class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int val=solve(0,stoneValue,dp);
        if(val<0) return "Bob";
        else if(val==0) return "Tie";
        else return "Alice";
        
    }
    public static int solve(int idx,int stoneValue[], int dp[]){
        int n=stoneValue.length;
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int score=Integer.MIN_VALUE;
        score=Math.max(score,stoneValue[idx]-solve(idx+1,stoneValue,dp));
        if(idx+1<n) score=Math.max(score,stoneValue[idx]+stoneValue[idx+1]-solve(idx+2,stoneValue,dp));
        if(idx+2<n) score=Math.max(score,stoneValue[idx]+stoneValue[idx+1]+stoneValue[idx+2]-solve(idx+3,stoneValue,dp));
        return dp[idx]=score;
    }
}