class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans=0;
        for(int i=0;i<left.length;i++){
            ans=Math.max(ans, left[i]-0);
        }
        for(int i=0;i<right.length;i++){
            ans=Math.max(ans, Math.abs(n-right[i]));
        }
        return ans;
    }
}