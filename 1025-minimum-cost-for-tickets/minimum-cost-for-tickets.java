class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,days,costs,dp);
    }
    public static int solve(int i, int days[], int costs[],int dp[]){
        int n=days.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int op1=costs[0]+solve(i+1,days,costs,dp);
        int j=i;
        int max_7days=days[i]+7;
        while(j<n && days[j]<max_7days) j++;
        int op2=costs[1]+solve(j,days,costs,dp);
        int max_30days=days[i]+30;
        j=i;
        while(j<n && days[j]<max_30days) j++;
        int op3=costs[2]+solve(j,days,costs,dp);

        return dp[i]=Math.min(op1, Math.min(op2,op3));
    }
}