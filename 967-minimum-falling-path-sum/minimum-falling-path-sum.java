class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int dp[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j]=100000;
            }
        }
        
        for(int j=0;j<col;j++) dp[0][j]=matrix[0][j];
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                if(j-1>=0) dp[i][j]=Math.min(dp[i][j], dp[i-1][j-1]+matrix[i][j]);
                           dp[i][j]=Math.min(dp[i][j], dp[i-1][j]+matrix[i][j]);
                if(j+1<col) dp[i][j]=Math.min(dp[i][j], dp[i-1][j+1]+matrix[i][j]);
            }
        }
    int ans=100000;
    for(int j=0;j<col;j++) ans=Math.min(ans,dp[row-1][j]);
    return ans;
    }
}