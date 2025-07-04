class Solution {
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        boolean dp[]=new boolean[n+1];
        dp[0]=true;
        dp[1]=false;
        if(nums[0]==nums[1]) dp[2]=true;
        for(int i=3;i<=n;i++){
            if(nums[i-1]==nums[i-2] && dp[i-2]==true) dp[i]=true;
            if(nums[i-1]==nums[i-2] && nums[i-2]==nums[i-3] && dp[i-3]==true) dp[i]=true;
            if(nums[i-1]-nums[i-2]==1  && nums[i-2]-nums[i-3]==1 && dp[i-3]==true) dp[i]=true;
        }
        return dp[n];
    }
}