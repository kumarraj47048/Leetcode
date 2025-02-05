class Solution {
    public int longestPalindromeSubseq(String s) {
        char ch1[]=s.toCharArray();
        int n=ch1.length;
        char ch2[]=new char[n];
        int idx=0;
        for(int i=n-1;i>=0;i--){
           ch2[idx++]=ch1[i];
        }
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
        }
        return solve(ch1,ch2,0,0,dp);
    }
    public static int solve(char ch1[], char ch2[], int i, int j, int dp[][]){
        int n=ch1.length;
        if(i>=n || j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(ch1[i]==ch2[j]) return dp[i][j]=1+solve(ch1,ch2,i+1,j+1,dp);
        else return dp[i][j]=Math.max(solve(ch1,ch2,i+1,j,dp),solve(ch1,ch2,i,j+1,dp));
    }
}