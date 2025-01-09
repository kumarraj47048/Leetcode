class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return Math.max(rec(nums,0,dp),rec(nums,1,dp));
    }
    public static int rec(int nums[], int idx, int dp[]){
        int n=nums.length;
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int a=rec(nums,idx+1,dp);
        int b=rec(nums,idx+2,dp);
        return dp[idx]=Math.max(a,b+nums[idx]);
    }
}