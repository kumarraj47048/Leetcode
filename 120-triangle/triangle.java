class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int col=triangle.get(row-1).size();
        int dp[][]=new int[row+1][col+1];

        for(int i=0;i<=row;i++){
            Arrays.fill(dp[i],100000);
        }

        dp[1][1]=triangle.get(0).get(0);

        for(int i=2;i<=row;i++){
            
            for(int j=1;j<=triangle.get(i-1).size();j++){
                int curr=triangle.get(i-1).get(j-1);
                dp[i][j]=Math.min(dp[i][j],curr+dp[i-1][j]);
                if(i!=1) dp[i][j]=Math.min(dp[i][j],curr+dp[i-1][j-1]);
            }
        }

        int ans=100000;
        for(int j=1;j<=col;j++){
            ans=Math.min(ans,dp[row][j]);
        }

        return ans;
    }
}