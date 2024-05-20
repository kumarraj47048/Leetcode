class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=nums.length;
        int p[]=new int[n];
        p[0]=1;
        for(int i=1;i<n;i++){
            if(nums[i]%2!=nums[i-1]%2) p[i]=p[i-1]+1;
            else p[i]=p[i-1];
        }
        int q=queries.length;
      boolean ans[]=new boolean[q];
      for(int i=0;i<q;i++){
        int f=queries[i][0];
        int t=queries[i][1];
        if(t-f<=p[t]-p[f]) ans[i]=true;
        else ans[i]=false;
      }
      return ans;
    }
}