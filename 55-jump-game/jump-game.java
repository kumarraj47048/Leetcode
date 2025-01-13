class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=1;j--){
                if(i-j<=nums[j-1] && dp[j]==1) dp[i]=1;
            }
        }
        if(dp[n]==1) return true;
        else return false;
    }
}