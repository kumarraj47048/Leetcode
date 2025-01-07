class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        int dp[][]=new int[d+1][n+1];
        for(int i=0;i<=d;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=100000000;
            }
        }
        int arr[]=new int[n+1];
        for(int i=1;i<=n;i++) arr[i]=jobDifficulty[i-1];
        dp[0][0]=0;
        for(int i=1;i<=d;i++){
            for(int j=1;j<=n;j++){
                int max=0;
                for(int k=j;k>=1;k--){
                    max=Math.max(max,arr[k]);
                    dp[i][j]=Math.min(dp[i][j], dp[i-1][k-1]+max);
                }
            }
        }
    if(dp[d][n]==100000000) return -1;
    return dp[d][n];
    }
}