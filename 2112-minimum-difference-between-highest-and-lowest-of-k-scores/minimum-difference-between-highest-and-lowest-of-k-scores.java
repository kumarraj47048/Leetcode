class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        if(k==1) return 0;
        int min=1000000;
        for(int i=k-1;i<nums.length;i++){
            min=Math.min(min,nums[i]-nums[i-k+1]);
        }
    return min;
    }
}