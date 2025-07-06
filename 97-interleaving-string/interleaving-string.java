class Solution {
    char ch1[];
    char ch2[];
    char tar[];
    int n,m,N;
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        ch1=s1.toCharArray();
        ch2=s2.toCharArray();
        tar=s3.toCharArray();
        n=ch1.length;
        m=ch2.length;
        N=tar.length;
        dp=new Boolean[n+1][m+1];
       // System.out.println(n+" "+m+" "+N);
        return solve(0,0);
    }
    public boolean solve(int i, int j){
        if(i==n && j==m && i+j==N) return true;
       // if(i>=n || j>=m) return false;
        if(i+j>=N) return false;
       
        if(dp[i][j]!=null) return dp[i][j];
        Boolean res=false;
        if(i<n && ch1[i]==tar[i+j]) res=res||solve(i+1,j);
        if(j<m && ch2[j]==tar[i+j]) res=res||solve(i,j+1);
        return dp[i][j]=res;
    }
}