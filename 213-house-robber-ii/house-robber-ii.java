class Solution {
    public int rob(int[] nums) {
        if(nums.length==1 ) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        return solve(nums);
    }
    public static int solve(int nums[]){
        int ans1=0;
        int ans2=0;
        int n=nums.length;
        // base case for first part when taking first element
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n-1;i++){
            int inc=nums[i]+prev2;
            int exc=prev1;
            ans1=Math.max(inc,exc);
            prev2=prev1;
            prev1=ans1;
        }
        
        // base case for second part when taking last element
        prev1=nums[1];
        prev2=0;
        
        for(int i=2;i<n;i++){
            int inc=nums[i]+prev2;
            int exc=prev1;
            ans2=Math.max(inc,exc);
            prev2=prev1;
            prev1=ans2;
        }
        return Math.max(ans1,ans2);
    }
}