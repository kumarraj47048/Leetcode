class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][]=new int[m+1][n+1];

        dp[0][0]=0;
         for(int k=0;k<strs.length;k++){
            int ct1=ctOne(strs[k]);
            int ct0=ctz(strs[k]);
            for(int i=m;i>=ct0;i--){
              for(int j=n;j>=ct1;j--){
                dp[i][j]=Math.max(dp[i-ct0][j-ct1]+1, dp[i][j]);
                } 
            }
        }
        return dp[m][n];
    }
    int ctOne(String s){
        int ct=0;
        for(char c:s.toCharArray()){
            if(c=='1') ct++;
        }
        return ct;
    }

      int ctz(String s){
        int ct=0;
        for(char c:s.toCharArray()){
            if(c=='0') ct++;
        }
        return ct;
    }
}