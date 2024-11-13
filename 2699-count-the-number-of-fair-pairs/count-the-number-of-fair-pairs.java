class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        long left=count(nums,lower-1);
        long right=count(nums,upper);
        return right-left;
        
    }
    public static long count(int[] nums, int limit){
        int n=nums.length;
        long ct1=0;
        int p1=0;
        int p2=n-1;

        while(p1<p2){
            while(p1<p2 && nums[p1]+nums[p2]>limit){
                p2--;
            }
            ct1+=(long)(p2-p1);
            p1++;
        }
        return ct1;
    }
}