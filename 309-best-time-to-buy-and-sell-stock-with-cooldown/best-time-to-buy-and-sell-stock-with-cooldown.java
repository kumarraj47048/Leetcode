class Solution {
    //HashMap<String,Integer> map=new HashMap<>();
    int dp[][][];
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n+1][2][3];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,false,-2,prices);
    }
    public int solve(int idx, boolean sell, int cooldown, int prices[]){
        if(idx==prices.length) return 0;
       // String key=idx+","+sell+","+cooldown;
      //  if(map.containsKey(key)) return map.get(key);
        int temp=idx-cooldown;
        if(temp>2) temp=2;
        int x=sell?1:0;
        if(dp[idx][x][temp]!=-1) return dp[idx][x][temp];
        int take=0;
        int not_take=0;
        if(sell){
            take=prices[idx]+solve(idx+1,false,idx,prices);
            not_take=solve(idx+1,true,cooldown,prices);
        }
        else{
            if(idx-cooldown>1) take=-prices[idx]+solve(idx+1,true,cooldown,prices);
            not_take=solve(idx+1,false,cooldown,prices);
        }
        
       // map.put(key,Math.max(take,not_take));

        return dp[idx][x][temp]=Math.max(take,not_take);
    }
}