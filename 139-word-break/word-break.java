class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        char ch[]=s.toCharArray();
        Boolean dp[]=new Boolean[ch.length];
        return solve(0,ch,wordDict,dp);
    }
    public static boolean solve(int i, char ch[], List<String> wordDict, Boolean dp[]){
        int n=ch.length;
        if(i>=n) return true;
        if(dp[i]!=null) return dp[i];
        boolean check=false;
        for(String s:wordDict){
            char ch2[]=s.toCharArray();
            if(func(ch,i,ch2)){
              if(solve(i+ch2.length,ch,wordDict,dp)) check=true;
            }
        }
    return dp[i]=check;
    }

    public static boolean func(char ch1[], int i, char ch2[]){
        int n=ch1.length;
        int m=ch2.length;
        int p1=i;
        int p2=0;
        while(p1<n && p2<m){
            if(ch1[p1]==ch2[p2]){
                p1++;
                p2++;
            }
            else return false;
        }
        return p2>=m;
    }
}