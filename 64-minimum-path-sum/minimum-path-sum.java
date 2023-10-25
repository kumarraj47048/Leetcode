class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
       // Arrays.fill(dp,Integer.MAX_VALUE);
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               dp[i][j]=-1;
           }
       }
    int ans=func(0,0,grid,dp);
    return ans;
    }

    public static int func(int i, int j, int grid[][], int dp[][]){
        int m=grid.length;
        int n=grid[0].length;
        if(i>=m || j>=n) return Integer.MAX_VALUE;
         if(i==m-1 && j==n-1) return grid[i][j];
          if(dp[i][j]!=-1) return dp[i][j];
       
      
        dp[i][j]=grid[i][j]+ Math.min(func(i+1,j,grid,dp), func(i,j+1,grid,dp));
        return dp[i][j];
    }
}