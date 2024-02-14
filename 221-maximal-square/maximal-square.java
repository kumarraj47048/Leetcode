class Solution {
    int maxK=0;
    public int maximalSquare(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int dp[][]=new int[row+1][col+1];
        for(int i=0;i<row;i++){
             Arrays.fill(dp[i],-1);
        }
        solve(matrix,0,0,dp);
        return maxK*maxK;
    }
    public int solve(char matrix[][], int i, int j, int dp[][]){
        if(i>=matrix.length || j>=matrix[0].length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=solve(matrix,i,j+1,dp);
        int diag=solve(matrix,i+1,j+1,dp);
        int down=solve(matrix,i+1,j,dp);
        
        if(matrix[i][j]== '1'){
             dp[i][j]=1+ Math.min(right, Math.min(down,diag));
            maxK=Math.max(maxK,dp[i][j]);   
        }
        else dp[i][j]=0;
        return dp[i][j];
    }
}