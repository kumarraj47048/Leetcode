class Solution {
    public int maxMoves(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int dp[][]=new int[row+1][col+1];
        int max=0;
        for(int i=0;i<row;i++){
             if(i-1>=0 && grid[i][1]>grid[i-1][0]){
                    dp[i+1][2]=Math.max(dp[i+1][2],dp[i][1]+1);
                    max=Math.max(max,dp[i+1][2]);
                }
                 if(grid[i][1]>grid[i][0]){
                    dp[i+1][2]=Math.max(dp[i+1][2],dp[i+1][1]+1);
                    max=Math.max(max,dp[i+1][2]);
                }
                 if(i+1<row && grid[i][1]>grid[i+1][0]){
                    dp[i+1][2]=Math.max(dp[i+1][2],dp[i+2][1]+1);
                    max=Math.max(max,dp[i+1][2]);
                }
        }
        for(int j=2;j<col;j++){
            for(int i=0;i<row;i++){
                if(i-1>=0 && j-1>=0 && grid[i][j]>grid[i-1][j-1] && dp[i][j]>0){
                    dp[i+1][j+1]=Math.max(dp[i+1][j+1],dp[i][j]+1);
                    max=Math.max(max,dp[i+1][j+1]);
                }
                 if(j-1>=0 && grid[i][j]>grid[i][j-1] && dp[i+1][j]>0){
                    dp[i+1][j+1]=Math.max(dp[i+1][j+1],dp[i+1][j]+1);
                    max=Math.max(max,dp[i+1][j+1]);
                }
                 if(i+1<row && j-1>=0 && grid[i][j]>grid[i+1][j-1] && dp[i+2][j]>0){
                    dp[i+1][j+1]=Math.max(dp[i+1][j+1],dp[i+2][j]+1);
                    max=Math.max(max,dp[i+1][j+1]);
                }
            }
        }
        return max;
    }
}