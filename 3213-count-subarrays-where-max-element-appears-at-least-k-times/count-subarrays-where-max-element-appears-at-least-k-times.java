class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        long ct=0;
        int max=Integer.MIN_VALUE;
        for(int i:nums){
            max=Math.max(max,i);
        }
       
        int maxCt=0;
        int st=0;
        for(int end=0;end<n;end++){
            if(nums[end]==max) maxCt++;
            while(maxCt==k){
                if(nums[st]==max) maxCt--;
                st++;
            }
            ct+=st;
        }
        return ct;
    }
}