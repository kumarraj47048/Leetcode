class Solution {
    public int maximumCandies(int[] candies, long k) {
        long low=0;
        long high=(long)1000000*(long)1000000;
        long ans=1;
        long sum=0;
        for(int i:candies) sum+=(long)i;
        if(sum<k) return 0;
        while(low<=high){
            long mid=(low+high)/2;
            if(mid==0) break;
            if(bs(candies,mid,k)){
                ans=mid;
                low=mid+1;
            }else high=mid-1;
        }
    return (int)ans;
    }
    public static boolean bs(int nums[],long mid,long k){
        int n=nums.length;
        long ct=0;
        for(int i:nums){
            ct+=(long)i/mid;
        }
        return ct>=k;
    }
}