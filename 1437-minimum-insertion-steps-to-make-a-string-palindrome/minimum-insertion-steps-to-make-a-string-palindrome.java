class Solution {
    public int minInsertions(String s) {
        char ch[]=s.toCharArray();
        int n=ch.length;
        char ch2[]=new char[n];
        int idx=0;
        for(int i=n-1;i>=0;i--){
            ch2[idx++]=ch[i];
        }
        int dp[][]=new int[n+1][n+1];
        // for(int i=1;i<=n;i++){
        //     dp[0][i]=i;
        //     dp[i][0]=i;
        // }
        //int dp[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(ch[i-1]!=ch2[j-1]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                else dp[i][j]=1+dp[i-1][j-1];
            }
        }
        return n-dp[n][n];
    }
}