class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count=0;
        int left=0;
        int right=0;
        int product=1;
        while(right<nums.length && left<=right){
          product=product*nums[right];
            while(product>=k && left<=right){
                product=product/nums[left];
                left++;
            }
            count=count+right-left+1;
            right++;
        }
        return count;
    }
}