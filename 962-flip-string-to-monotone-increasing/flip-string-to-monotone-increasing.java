class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        char ch[]=s.toCharArray();
        int dp[][]=new int[n][2];
        if(ch[0]=='0') dp[0][1]=1;
        else dp[0][0]=1;
        
        for(int i=1;i<n;i++){
            if(ch[i]=='0'){
                int x=dp[i-1][1]+1; // previous is 0  -> 1,0 is not possible 
                int y=dp[i-1][0];
                dp[i][0]=dp[i-1][0];
                dp[i][1]=Math.min(dp[i-1][1],dp[i-1][0])+1;
            }
            else{
                dp[i][1]=Math.min(dp[i-1][1],dp[i-1][0]);
                dp[i][0]=dp[i-1][0]+1;
            }
        }
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }
}