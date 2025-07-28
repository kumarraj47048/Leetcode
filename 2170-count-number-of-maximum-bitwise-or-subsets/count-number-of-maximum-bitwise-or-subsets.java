class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i:nums) max=max|i;
        return solve(0,0,nums,max);
    }
    public int solve(int idx,int curr, int nums[], int max){
        int n=nums.length;
        if(idx>=n){
            if(curr==max) return 1;
            else return 0;
        }
        return solve(idx+1,curr|nums[idx],nums,max) + solve(idx+1,curr,nums,max);
    }
}