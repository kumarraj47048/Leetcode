class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int dp[][][]=new int[group.length][n+1][minProfit+1];
        for(int i=0;i<group.length;i++){
            for(int j=0;j<=n;j++) Arrays.fill(dp[i][j],-1);
        }
        int take=solve(0,group[0],Math.min(profit[0],minProfit),n,minProfit,group,profit,dp);
        int not_take=solve(0,0,0,n,minProfit,group,profit,dp);
        int mod=1000000007;
       
        return (take+not_take)%mod;
    }
    public static int solve(int idx,int people,int val_profit,int n, int minProfit,int group[], int profit[], int dp[][][]){
        int mod=1000000007;
        if(people>n) return 0;
        if(idx>=group.length) return 0;
        if(idx==group.length-1){
            if(people<=n && val_profit>=minProfit) return 1;
            return 0;
        }
        if(dp[idx][people][val_profit]!=-1) return dp[idx][people][val_profit];
        int take=solve(idx+1,people+group[idx+1],Math.min(val_profit+profit[idx+1],minProfit),n,minProfit,group,profit,dp);
        int not_take=solve(idx+1,people,val_profit,n,minProfit,group,profit,dp);
        return dp[idx][people][val_profit]=(take+not_take)%mod;
    }
}