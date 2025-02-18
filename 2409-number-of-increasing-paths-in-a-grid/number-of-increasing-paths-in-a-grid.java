class Solution {
    public int countPaths(int[][] grid) {
        int mod=1000000007;
        int n=grid.length;
        int m=grid[0].length;
        int ct=0;
        int dp[][]=new int[n][m];
        for(int row[]:dp) Arrays.fill(row,-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ct=(ct+solve(i,j,grid,dp))%mod;
            }
        }
        return (ct+(m*n))%mod;
    }
    public static int solve(int i, int j, int grid[][],int dp[][]){
        int mod=1000000007;
        int n=grid.length;
        int m=grid[0].length;
        int ways=0;
        if(i>=n || i<0) return 0;
        if(j>=m || j<0) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];

        if(i+1<n && grid[i][j]<grid[i+1][j]) ways=(ways+1+solve(i+1,j,grid,dp))%mod;
        if(i-1>=0 && grid[i][j]<grid[i-1][j]) ways=(ways+1+solve(i-1,j,grid,dp))%mod;
        if(j+1<m && grid[i][j]<grid[i][j+1]) ways=(ways+1+solve(i,j+1,grid,dp))%mod;
        if(j-1>=0 && grid[i][j]<grid[i][j-1]) ways=(ways+1+solve(i,j-1,grid,dp))%mod;
        return dp[i][j]=ways%mod;
    }
}