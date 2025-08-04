class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        char ch[]=s.toCharArray();
        int dp[]=new int[n+1];
        dp[0]=1;
        if(s.charAt(0)!='0') dp[1]=1;
        for(int i=2;i<=n;i++){
            int ct=0;
            String x=s.substring(i-1,i);
            int val=Integer.parseInt(x);
            if(x.charAt(0)!='0') ct+=dp[i-1];

            x=s.substring(i-2,i);
            val=Integer.parseInt(x);
            if(x.charAt(0)!='0' && val<=26) ct+=dp[i-2];

            dp[i]=ct;
        }
        return dp[n];
    }
}