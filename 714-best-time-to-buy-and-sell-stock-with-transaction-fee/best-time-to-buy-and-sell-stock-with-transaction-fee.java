class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int ans=0;
        boolean buy=true;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        ans=solve(0,prices,fee,buy,dp);
        return ans;
    }
    public static int solve(int idx,int prices[],int fee,boolean buy, int dp[][]){
        int n=prices.length;
        if(idx>=n) return 0;
        int decide=0;
        if(buy) decide=1;
        if(dp[idx][decide]!=-1) return dp[idx][decide];
        int result=0;
        if(buy){
            int consider=solve(idx+1,prices,fee,false,dp)-prices[idx];
            int not_consider=solve(idx+1,prices,fee,true,dp);
            result=Math.max(consider,not_consider);
        }
        else{ // sell
            int consider=solve(idx+1,prices,fee,true,dp)+prices[idx]-fee;
            int not_consider=solve(idx+1,prices,fee,false,dp);
            result=Math.max(consider,not_consider);
        }
        return dp[idx][decide]=result;
    }
}