class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int xor=0;
        int n=arr.length;
        int q=queries.length;
        int ans[]=new int[q];
        int pref[]=new int[n];
        pref[0]=arr[0];
        for(int i=1;i<n;i++){
            pref[i]=pref[i-1]^arr[i];
        }
        
        for(int i=0;i<q;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            if(left==0)
            ans[i]=pref[right];
            else ans[i]=pref[right]^pref[left-1];
        }
        return ans;
    }
}