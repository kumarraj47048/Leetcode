class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][]=new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
        return solve(0,0,nums1,nums2,dp);
    }
    public int solve(int i, int j, int nums1[], int nums2[], int dp[][]){
        int n=nums1.length;
        int m=nums2.length;

        if(i>=n || j>=m) return Integer.MIN_VALUE;
        if(dp[i][j]!=Integer.MIN_VALUE) return dp[i][j];
        int sum=nums1[i]*nums2[j];
        int not_pick_from_1=solve(i+1,j,nums1,nums2,dp);
        int not_pick_from_2=solve(i,j+1,nums1,nums2,dp);
        int pick=(nums1[i]*nums2[j])+Math.max(0,solve(i+1,j+1,nums1,nums2,dp));
        //int not_pick_from_both=solve(i+1,j+1,nums1,nums2);

        sum=Math.max(not_pick_from_1,sum);
        sum=Math.max(not_pick_from_2,sum);
       // sum=Math.max(not_pick_from_both,sum);
        sum=Math.max(pick,sum);
        
        return dp[i][j]=sum;
    }
}