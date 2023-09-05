class Solution {
    public int numDecodings(String s) {
        Integer dp[]=new Integer[s.length()];
        return helperFunc(s,0,dp);
    }
    public int helperFunc(String s, int i,Integer dp[]){
        if(i>=s.length())
        return 1;
        if(s.charAt(i)=='0')
        return 0;
        if(dp[i]!=null)
        return dp[i];
        int ways=helperFunc(s,i+1,dp);
        if(i+2<=s.length() && Integer.parseInt(s.substring(i,i+2))<=26){
            ways+=helperFunc(s,i+2,dp);
        }
        dp[i]=ways;
        return dp[i];
    }
}