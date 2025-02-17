class Solution {
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int m=1;
        int maxScore=0;
        int dp[][][]=new int[n][2*n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2*n;j++){
                dp[i][j][0]=-1;
                dp[i][j][1]=-1;
            }
        }
        return solve(0,1,1,piles,dp);
    }
    public static int solve(int idx,int m, int op, int piles[], int dp[][][]){
        if(idx>piles.length-1) return 0;
        
        int score=0;
        if(op%2==0) score=Integer.MAX_VALUE;
        int currSum=0;
        if(dp[idx][m][op%2]!=-1) return dp[idx][m][op%2];
        if(op%2==0){
            for(int i=idx;i<Math.min(2*m+idx,piles.length);i++){
                currSum+=piles[i];
                score=Math.min(score,solve(i+1,Math.max(m,i-idx+1),op+1,piles,dp));
            }
        }
        else{
            for(int i=idx;i<Math.min(2*m+idx,piles.length);i++){
                currSum+=piles[i];
                score=Math.max(score,currSum+solve(i+1,Math.max(m,i-idx+1),op+1,piles,dp));
            }
        }
        return dp[idx][m][op%2]=score;
    }
}