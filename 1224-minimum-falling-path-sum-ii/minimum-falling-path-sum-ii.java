class Solution {
    public int minFallingPathSum(int[][] grid) {
        int col=grid[0].length;
        int row=grid.length;
        int dp[][]=new int[row][col];
        // Arrays.fill(dp,Integer.MAX_VALUE);
        
        for(int j=0;j<col;j++){
            dp[0][j]=grid[0][j];
        }
        
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=0;k<col;k++){
                    if(k!=j)
                dp[i][j]=Math.min(dp[i][j], dp[i-1][k]+grid[i][j]);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<col;j++){
             ans=Math.min(ans,dp[row-1][j]);
        }
    return ans;
    }
}