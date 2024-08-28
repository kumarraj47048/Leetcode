class Solution {
    public int longestIdealString(String s, int k) {
        int dp[]=new int[26];
        int ans=1;
        int n=s.length();
        char ch[]=s.toCharArray();
        for(int i=0;i<n;i++){
            int ele=ch[i]-'a';
            for(int j=ele;j>=0 && ele-j<=k;j--){
                dp[ele]=Math.max(dp[ele],dp[j]+1);
            }
            for(int j=ele+1;j<26 && j-ele<=k;j++){
                dp[ele]=Math.max(dp[ele],dp[j]+1);
            }
            ans=Math.max(ans,dp[ele]);
        }
    return ans;
    }
}