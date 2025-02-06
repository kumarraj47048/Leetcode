class Solution {
    public int numberOfArrays(String s, int k) {
        int n=s.length();
        char ch[]=s.toCharArray();
        int dp[]=new int[n+1];
        dp[0]=1;
        int mod=1000000007;
        for(int i=1;i<=n;i++){
            String temp="";
            for(int j=i;j>=i-10 && j>=1;j--){
                temp=ch[j-1]+temp;
                long x=Long.parseLong(temp);
                if(x<=(long)k && x>=1 && ch[j-1]!='0') dp[i]=(dp[i]+dp[j-1])%mod;
            }
           // System.out.print(dp[i]+" ");
        }
        
        return dp[n];
    }
}