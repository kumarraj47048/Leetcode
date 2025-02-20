class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int dp[][]=new int[locations.length][fuel+1];
        for(int i=0;i<locations.length;i++){
            for(int j=0;j<=fuel;j++){
                dp[i][j]=-1;
            }
        }
        return solve(start,finish,fuel,locations,dp);
    }
    public static int solve(int pos, int finish,int fuel, int locations[], int dp[][]){
        if(fuel<0) return 0;
        int mod=1000000007;
        if(dp[pos][fuel]!=-1) return dp[pos][fuel];
        int ways=0;
        if(pos==finish) ways=1;
        for(int i=0;i<locations.length;i++){
            if(i!=pos){
                int diff=Math.abs(locations[i]-locations[pos]);
                ways=(ways+solve(i,finish,fuel-diff,locations,dp))%mod;
            }
        }
        return dp[pos][fuel]=ways;
    }
}