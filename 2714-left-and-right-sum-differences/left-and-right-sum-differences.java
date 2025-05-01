class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int right=0;
        for(int i:nums) right+=i;
        int left=0;
        int ans[]=new int[n];
       
        for(int i=0;i<n;i++){
            left+=nums[i];
            ans[i]=Math.abs(left-right);
            right-=nums[i];
        }
        return ans;
    }
}