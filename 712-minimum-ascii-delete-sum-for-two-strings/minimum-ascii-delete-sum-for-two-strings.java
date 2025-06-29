class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();
        int n=ch1.length;
        int m=ch2.length;

        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
           dp[i][0]=ch1[i-1]+dp[i-1][0];
        }
        for(int i=1;i<=m;i++){
           dp[0][i]=ch2[i-1]+dp[0][i-1];
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(ch1[i-1]==ch2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int del_from_first=ch1[i-1]+ dp[i-1][j];
                    
                    int del_from_second=ch2[j-1]+ dp[i][j-1];

                    dp[i][j]=Math.min(del_from_first, del_from_second);
                    
                }
            }
        }

        return dp[n][m];
    }
}