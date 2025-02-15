class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int dp[][]=new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(nums1,nums2,0,0,dp);
    }
    public static int solve(int nums1[], int nums2[],int i, int j,int dp[][]){
        int n=nums1.length;
        int m=nums2.length;
        if(i>=n || j>=m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(nums1[i]==nums2[j]) return dp[i][j]=1+solve(nums1,nums2,i+1,j+1,dp);
        else return dp[i][j]=Math.max(solve(nums1,nums2,i+1,j,dp),solve(nums1,nums2,i,j+1,dp));
    }
}