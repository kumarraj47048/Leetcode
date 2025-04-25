class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int ct[]=new int[102];
        int n=nums.length;
        for(int i:nums){
            ct[i]++;
        }
        int pf[]=new int[102];
        pf[0]=ct[0];
        for(int i=1;i<=100;i++) pf[i]=pf[i-1]+ct[i];

        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0) ans[i]=pf[nums[i]-1];
           // else ans[i]=pf[nums[i]];
        }

        return ans;
    }
}