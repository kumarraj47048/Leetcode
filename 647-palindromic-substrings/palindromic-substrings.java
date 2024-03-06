class Solution {
    public int countSubstrings(String s) {
       int ct=0;
       int n=s.length();
       char ch[]=new char[n];
       ch=s.toCharArray();
       int dp[][]=new int[n][n];
       for(int i=0;i<n;i++){
           dp[i][i]=1;
           ct++;
       }
       for(int i=0;i<n-1;i++){
           if(ch[i]==ch[i+1]){
               dp[i][i+1]=1;
               ct++;
           }
       }
        
     for(int sz=3;sz<=n;sz++){
         for(int i=0;i<n-sz+1;i++){
             int j=i+sz-1;
             if(ch[i]==ch[j] && dp[i+1][j-1]==1){
                 ct++;
                 dp[i][j]=1;
             }
         }
         
     }
        return ct;
    }
    
}