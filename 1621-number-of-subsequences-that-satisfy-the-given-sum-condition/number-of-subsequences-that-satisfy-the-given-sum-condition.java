class Solution {
    public int numSubseq(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        long pow[]=new long[n+1];
        long mod=1000000007;
        pow[0]=1;
        pow[1]=2;
        for(int i=2;i<=n;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }

        int left=0;
        int right=n-1;
        long ans=0;
        while(left<=right){
            if(nums[left]+nums[right]>target) right--;
            else{
               ans+=(pow[right-left])%mod;
               left++;
            }
        }
        return (int)(ans%mod);
    }
}