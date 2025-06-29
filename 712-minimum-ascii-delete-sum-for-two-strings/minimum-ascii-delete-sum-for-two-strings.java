class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,s1,s2,dp);
    }
    public static int solve(int i, int j, String s1, String s2, int dp[][]){
        int n=s1.length();
        int m=s2.length();
        if(i>=n && j>=m) return 0;
        if(i>=n){
            int sum=0;
            while(j<m) sum+=s2.charAt(j++);
            return sum;
        }

        if(j>=m){
            int sum=0;
            while(i<n) sum+=s1.charAt(i++);
            return sum;
        }

        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=solve(i+1,j+1,s1,s2,dp);
        else{
            int a=s2.charAt(j)+solve(i,j+1,s1,s2,dp);
            int b=s1.charAt(i)+solve(i+1,j,s1,s2,dp);
            
            return dp[i][j]=Math.min(a,b);
        }
    }
}