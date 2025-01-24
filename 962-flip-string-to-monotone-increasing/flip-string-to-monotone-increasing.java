class Solution {
    public int minFlipsMonoIncr(String s) {
        char ch[]=s.toCharArray();
        int n=s.length();
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        dp[n-1][0]=func(0,0,ch,dp);
        dp[n-1][1]=func(0,1,ch,dp);

        return Math.min(dp[n-1][0], dp[n-1][1]);
    }
    public static int func(int i, int op, char ch[], int dp[][]){
        int n=ch.length;
        if(i==n) return 0;
        if(ch[i]=='0'){
            if(op==0){
                if(dp[i][0]!=-1) return dp[i][0];
                else dp[i][0]=Math.min(func(i+1,0,ch,dp),func(i+1,1,ch,dp));
            }
            else{
                if(dp[i][1]!=-1) return dp[i][1];
                else dp[i][1]=func(i+1,1,ch,dp)+1;
            }
        }
        else{
            if(op==0){
                if(dp[i][0]!=-1) return dp[i][0];
                else dp[i][0]=Math.min(func(i+1,0,ch,dp),func(i+1,1,ch,dp))+1;
            }
            else{
                if(dp[i][1]!=-1) return dp[i][1];
                else dp[i][1]=func(i+1,1,ch,dp);
            }
        }
        return dp[i][op];
    }
}