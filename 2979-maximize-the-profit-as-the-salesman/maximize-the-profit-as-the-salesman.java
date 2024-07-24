class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers,(a,b)->(a.get(1)-b.get(1)));
       // int n=offers.size();
        int dp[]=new int[n+1];
        int mostGold=0;
        int currIdx=0;

        for(int i=0;i<n;i++){
            dp[i]=(i>0)?dp[i-1]:0;
            while(currIdx<offers.size() && offers.get(currIdx).get(1)==i){
                int st=offers.get(currIdx).get(0);
                int gold=offers.get(currIdx).get(2);
                dp[i]=Math.max(dp[i],(st>0?dp[st-1]:0)+gold);
                currIdx++;
            }
        }
    return dp[n-1];
    }
}