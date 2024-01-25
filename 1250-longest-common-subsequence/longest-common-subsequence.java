class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();
        int dp[][]=new int[n1][n2];
       for (int[] row : dp) 
            Arrays.fill(row, -1); 
       return func(text1,text2,n1,n2,dp);
    }
    public static int func(String text1, String text2, int n1, int n2,int dp[][]){
        if(n1==0 || n2==0) return 0;
        if(dp[n1-1][n2-1]!=-1) return dp[n1-1][n2-1];
        if(text1.charAt(n1-1)==text2.charAt(n2-1)) {
            dp[n1-1][n2-1]= 1+func(text1,text2,n1-1,n2-1,dp);
        }
        else dp[n1-1][n2-1]= Math.max(func(text1,text2,n1-1,n2,dp), func(text1,text2,n1,n2-1,dp));
        return dp[n1-1][n2-1];
    }
}