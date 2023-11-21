class Solution {
    public int countNicePairs(int[] nums) {
          long ans=0;
          long mod=1000000007;
          int n=nums.length;
          for(int i=0;i<n;i++){
              int temp=nums[i];
              long rev=0;
              while(temp>0){
                  long x=temp%10;
                  rev=rev*10+x;
                  temp=temp/10;
              }
              nums[i]-=rev;
          }
        
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            // int x=nums[i];
            long ct=1;
            while(i<n-1 && nums[i]==nums[i+1]){
                ct++;
                i++;
            }
           
            ans=(ans%mod +(ct*(ct-1)/2))%mod;
        }
        return (int)(ans%mod);
    }
}