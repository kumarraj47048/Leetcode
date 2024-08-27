class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,1);
        for(int i=2;i<=n;i++){
            for(int j=i-1;j>0;j--){
                if(nums[i-1]>nums[j-1]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int ans=0;
        for(int i:dp) ans=Math.max(ans,i);
        return ans;
    }
}