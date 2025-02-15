class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long dp[]=new long[n];
        Arrays.fill(dp,-1);
        return solve(0,questions,dp);
    }
    public static long solve(int i, int questions[][],long dp[]){
        int n=questions.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        long skip=solve(i+1,questions,dp);
        long not_skip=questions[i][0]+solve(i+questions[i][1]+1,questions,dp);
        return dp[i]=Math.max(skip,not_skip);
    }
}