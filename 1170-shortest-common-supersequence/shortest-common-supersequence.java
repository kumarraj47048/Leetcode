class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String str=lcs(str1,str2);
        String ans="";
        int p1=0,p2=0,p3=0;
        for(char c:str.toCharArray()){
            while(p1<str1.length() && str1.charAt(p1)!=c){
                ans+=str1.charAt(p1);
                p1++;
            }
            while(p2<str2.length() && str2.charAt(p2)!=c){
                ans+=str2.charAt(p2);
                p2++;
            } 
            ans+=c;
            p1++;
            p2++;
        }
        if(p1<str1.length()) ans+=str1.substring(p1);
        if(p2<str2.length()) ans+=str2.substring(p2);
        return ans;
    }
    public static String lcs(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        StringBuilder sb=new StringBuilder("");
        int i=m,j=n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]) i--;
            else j--;
        }
        return sb.reverse().toString();
    }
}