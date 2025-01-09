class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char ch1[]=text1.toCharArray();
        char ch2[]=text2.toCharArray();
        int n=ch1.length;
        int m=ch2.length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return rec(ch1,ch2,0,0,dp);
    }
    public static int rec(char ch1[], char ch2[], int i, int j,int dp[][]){
        int n=ch1.length;
        int m=ch2.length;
        if(i>=n || j>=m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(ch1[i]==ch2[j]) return dp[i][j]=1+rec(ch1,ch2,i+1,j+1,dp);
        else return dp[i][j]=Math.max(rec(ch1,ch2,i+1,j,dp), rec(ch1,ch2,i,j+1,dp));
    }
}