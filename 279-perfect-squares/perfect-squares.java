class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.sqrt(i);j++){
                
                    dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                
            }
        }
        return dp[n];
    }
    // public static boolean check(int n){
    //     double sqrt=Math.sqrt(n);
    //     return ((sqrt-Math.floor(sqrt))==0);
    // }
}