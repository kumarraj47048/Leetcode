class Solution {
    public int longestIdealString(String s, int k) {
        int n=s.length();
        int dp[]=new int[26];
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            int best=0;
            for(int j=0;j<26;j++){
               if(Math.abs(j-idx)<=k){
                 best=Math.max(best, dp[j]);
               }
            }
            dp[idx]=best+1;
        }
        int max=0;
        for(int i:dp) max=Math.max(max,i);
        return max;
    }
}