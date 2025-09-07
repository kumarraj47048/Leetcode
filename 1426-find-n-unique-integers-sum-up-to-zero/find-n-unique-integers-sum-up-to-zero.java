class Solution {
    public int[] sumZero(int n) {
        int ans[]=new int[n];
        int start=n/2;
        int idx=0;
        start=-1*start;
        while(idx<n){
             if(n%2==0 && start==0) start++;
             ans[idx]=start;
             start++;
            idx++;
        }
        return ans;
    }
}