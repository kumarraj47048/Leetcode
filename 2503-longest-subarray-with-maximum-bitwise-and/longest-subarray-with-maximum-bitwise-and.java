class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i:nums) max=Math.max(max,i);
        int ans=1;
        int ct=0;
        for(int i=0;i<n;i++){
            if(nums[i]==max){
                ct++;
            }
            else{
                ans=Math.max(ans,ct);
                ct=0;
            }
        }
        ans=Math.max(ans,ct);
        return ans;
    }
}