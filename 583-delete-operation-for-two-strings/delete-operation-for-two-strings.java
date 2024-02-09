class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        char s1[]=new char[m];
        char s2[]=new char[n];
        s1=word1.toCharArray();
        s2=word2.toCharArray();
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int l=dp[m][n];
        System.out.println(l);
        return m-l+n-l;
    }
}