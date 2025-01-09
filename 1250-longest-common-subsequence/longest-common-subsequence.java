class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        char ch1[]=text1.toCharArray();
        char ch2[]=text2.toCharArray();
        int dp[][]=new int[n][m];
        if(ch1[0]==ch2[0]) dp[0][0]=1;
        for(int i=1;i<m;i++){
            if(ch1[0]==ch2[i]) dp[0][i]=1;
            dp[0][i]=Math.max(dp[0][i],dp[0][i-1]);
        }
        for(int i=1;i<n;i++){
            if(ch1[i]==ch2[0]) dp[i][0]=1;
            dp[i][0]=Math.max(dp[i][0],dp[i-1][0]);
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(ch1[i]==ch2[j]) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}