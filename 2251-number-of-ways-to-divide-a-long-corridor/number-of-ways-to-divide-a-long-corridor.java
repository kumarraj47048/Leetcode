class Solution {
    public int numberOfWays(String corridor) {
        int mod=1000000007;
        int n=corridor.length();
        int dp[][]=new int[n+1][3];
        //base cases
        dp[n][0]=0;
        dp[n][1]=0;
        dp[n][2]=1;

        //filling the array in a bottom-up fashion

        for(int index=n-1;index>=0;index--){
            if(corridor.charAt(index)=='S'){
                dp[index][0]=dp[index+1][1];
                dp[index][1]=dp[index+1][2];
                dp[index][2]=dp[index+1][1];
            }
            else{
                dp[index][0]=dp[index+1][0];
                dp[index][1]=dp[index+1][1];
                dp[index][2]=(dp[index+1][0] + dp[index+1][2])%mod;
            }
        }
     return dp[0][0];
    }
}