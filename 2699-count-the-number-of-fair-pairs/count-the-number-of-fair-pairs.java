class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n=nums.length;
        long ct=0;
        long right=0;
        int p1=0,p2=n-1;
        Arrays.sort(nums);
        while(p1<p2){
            while(p1<p2 && nums[p1]+nums[p2]>upper) p2--;
            right+=p2-p1;
            p1++;
        }

        long left=0;
        p1=0;
        p2=n-1;
         while(p1<p2){
            while(p1<p2 && nums[p1]+nums[p2]>lower-1) p2--;
            left+=p2-p1;
            p1++;
        }

        return right-left;
    }
}