class Solution {
    public int findNumberOfLIS(int[] nums){
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        System.out.print(0+" "+1+", ");
        int t[]=new int[n];
        Arrays.fill(t,1);
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        t[i]=t[j];
                    }
                    else if(dp[i]==dp[j]+1){
                        t[i]+=t[j];
                    }
                }
                
            }
            max=Math.max(max,dp[i]);
           
        }
        int ct=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max) ct+=t[i];
            System.out.print(i+" "+dp[i]+", ");
        }
    return ct;
    }
}