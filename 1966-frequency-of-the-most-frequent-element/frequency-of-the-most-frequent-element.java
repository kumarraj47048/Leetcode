class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        int maxL=0;
        long curr=0;
        for(int right=0;right<nums.length;right++){
              int target=nums[right];
              curr+=nums[right];
             
              while((right-left+1)*target -curr>k){
                   curr-=nums[left];
                   left++;
              }
              maxL=Math.max(maxL,right-left+1);
        }
        return maxL;
    }
}