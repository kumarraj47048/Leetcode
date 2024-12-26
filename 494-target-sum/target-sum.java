class Solution {
    private int ct=0;
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        rec(0,0,nums,target);
        return ct;
    }
    private void rec(int idx,int sum, int nums[],int target){
        int n=nums.length;
        if(idx>=n){
           if(sum==target) ct++;
           return;
        }
        rec(idx+1,sum+nums[idx],nums,target);
        rec(idx+1,sum-nums[idx],nums,target);
    }
}