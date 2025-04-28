class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n=nums.length;
        long ct=0;
        int len=0;
        int p1=0;
        long sum=0;
        for(int i=0;i<n;i++){
            len++;
            sum+=nums[i];
            while(p1<=i && (sum*len)>=k){
                sum-=nums[p1];
                len--;
                p1++;
            }
            ct=(ct+(len));
        }
        return ct;
    }
}