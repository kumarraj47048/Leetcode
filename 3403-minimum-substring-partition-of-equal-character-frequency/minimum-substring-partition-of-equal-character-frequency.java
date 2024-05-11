class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n=s.length();
        int dp[]=new int[n+1];

        dp[1]=1;
        for(int i=2;i<=n;i++){
            int g[]=new int[26];
            int x=10000;
            for(int j=i;j>0;j--){
                char c=s.charAt(j-1);
                g[c-'a']++;
                if(check(g)){
                   int v=1+dp[j-1];
                   x=Math.min(x,v);
                }
            }
            dp[i]=x;
        }
        return dp[n];
    }
    boolean check(int g[]){
        int x=0;
        for(int i=0;i<26;i++){
            x=Math.max(x,g[i]);
        }
        for(int i=0;i<26;i++){
            if(g[i]!=0 && g[i]!=x) return false;
        }
        return true;
    }
}