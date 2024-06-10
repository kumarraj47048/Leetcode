class Solution {
    public int maximumLength(int[] nums, int k) {
        int n=nums.length;
        int dp[][]=new int[n][k+1];
        for(int i[]:dp) Arrays.fill(i,1);
        int ans=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                int max=1;
                for(int op=i-1;op>=0;op--){
                   if(nums[op]==nums[i]){
                    max=Math.max(max,dp[op][j]+1);
                   }
                   else if(j>0){
                    max=Math.max(max,dp[op][j-1]+1);
                   }
                }
                dp[i][j]=max;
                ans=Math.max(ans,max);
            }
        }
        return ans;
    }
}