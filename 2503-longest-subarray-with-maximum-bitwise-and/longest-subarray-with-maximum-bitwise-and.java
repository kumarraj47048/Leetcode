class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int len=0;
        int max=0;
        for(int i:nums) max=Math.max(max,i);
        int ct=0;
        for(int i:nums){
            if(i==max) ct++;
            else ct=0;
            len=Math.max(len,ct);
        }
        return len;
    }
}