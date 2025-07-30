class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int pf[][]=new int[n+1][33];
        boolean digit[]=new boolean[33];
        for(int i=0;i<32;i++){
            for(int j=0;j<n;j++){
                if(((nums[j]>>i)&1)==1) digit[i]=true;
            }
        }
        
        Arrays.fill(pf[n],n+1);

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<32;j++){
               pf[i][j]=pf[i+1][j];
               if(((nums[i]>>j)&1)==1) pf[i][j]=i;
            }
        }
        
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int ct=0;
            int max=i;
            for(int j=0;j<32;j++){
                if(digit[j]){
                   if(pf[i][j]!=n+1)
                   max=Math.max(max,pf[i][j]);
                }
            }
            ans[i]=max-i+1;
        }
    return ans;
    }
}