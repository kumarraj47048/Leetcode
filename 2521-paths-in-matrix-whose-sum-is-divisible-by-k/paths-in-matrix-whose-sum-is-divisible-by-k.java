class Solution {
    //HashMap<String,Integer> map=new HashMap<>();
    int dp[][][];
    int mod=(int)1e9+7;
    public int numberOfPaths(int[][] grid, int k) {
        int row=grid.length;
        int col=grid[0].length;
        dp=new int[grid.length][grid[0].length][k+1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,0,grid,k);
    }
    public int solve(int r, int c,int sum, int grid[][], int k){
        if(r==grid.length || c==grid[0].length) return 0;
        if(r==grid.length-1 && c==grid[0].length-1){
            if((sum+grid[r][c])%k==0) return 1;
            else return 0;
        }
        sum%=k;

        if(dp[r][c][sum]!=-1) return dp[r][c][sum];
       // String key=r+","+c+","+sum%k;
        //if(map.containsKey(key)) return map.get(key);
        int ans=0;
        ans=(ans+solve(r+1,c,sum+grid[r][c],grid,k))%mod;
        ans=(ans+solve(r,c+1,sum+grid[r][c],grid,k))%mod;
       // map.put(key,ans);
        return dp[r][c][sum]=ans;
    }
}