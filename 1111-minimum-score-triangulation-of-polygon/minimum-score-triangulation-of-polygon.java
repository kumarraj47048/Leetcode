class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solveMem(values,0,n-1,dp);
    }
    
     public int solveMem(int values[], int i, int j, int dp[][]){
        if(i+1==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i+1;k<=j-1;k++){
            int val= values[i]*values[j]*values[k] + solveMem(values,i,k,dp) + solveMem(values,k,j,dp);
            ans=Math.min(ans,val);
        }
        return dp[i][j]=ans;
    }

    public int solve(int values[], int i, int j){
        if(i+1==j) return 0;

        int ans=Integer.MAX_VALUE;
        for(int k=i+1;k<=j-1;k++){
            int val= values[i]*values[j]*values[k] + solve(values,i,k) + solve(values,k,j);
            ans=Math.min(ans,val);
        }
        return ans;
    }
}