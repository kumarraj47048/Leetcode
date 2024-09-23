class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        HashSet<String> set=new HashSet<>();
        for(String i:dictionary) set.add(i);
        char ch[]=s.toCharArray();
        int dp[]=new int[n+1];
        Arrays.fill(dp,n+2);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            StringBuilder sb=new StringBuilder("");
            for(int j=i;j>=1;j--){
                sb.insert(0,ch[j-1]);
                if(set.contains(sb.toString())){
                    dp[i]=Math.min(dp[i],dp[j-1]);
                }
                else dp[i]=Math.min(dp[i],dp[j-1]+i-j+1);
            }
        }
        return dp[n];
    }
}