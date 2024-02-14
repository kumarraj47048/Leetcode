class Solution {
    int maxK=0;
    public int maximalSquare(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int dp[][]=new int[row+1][col+1];
        for(int i=0;i<row;i++){
             Arrays.fill(dp[i],-1);
        }
        solveTab(matrix);
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

     public void solveTab(char matrix[][]){
        int row=matrix.length;
        int col=matrix[0].length;
        int dp[][]=new int[row+1][col+1];
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                int right=dp[i][j+1];
                int diag=dp[i+1][j+1];
                int down=dp[i+1][j];
                if(matrix[i][j]=='1'){
                dp[i][j]=1+Math.min(right, Math.min(diag,down));
                maxK=Math.max(maxK,dp[i][j]);
                }
            }
        }
    }
}