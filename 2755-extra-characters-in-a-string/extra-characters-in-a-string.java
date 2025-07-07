class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        int dp[]=new int[n+1];
        HashSet<String> set=new HashSet<>();
        for(String i:dictionary) set.add(i);

        Arrays.fill(dp,n+1);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            
            for(int j=i;j>=1;j--){
                String sb=s.substring(j-1,i);
                if(set.contains(sb)){
                    dp[i]=Math.min(dp[i],dp[j-1]);
                }else{
                    dp[i]=Math.min(i-j+1+dp[j-1],dp[i]);
                }
            }
        }

        return dp[n];
    }
}