class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        int pf[]=new int[n+1];
        for(int i=0;i<n;i++){
            pf[i+1]=pf[i]+nums[i];
        }
        int ct=0;
        int length=1;
        while(length<=n){
            int p1=1;
            int p2=p1+length-1;
            while(p2<=n){
                if(pf[p2]-pf[p1-1]==goal) ct++;
                p2++;
                p1++;
            }
            length++;
        }
        return ct;
    }
}