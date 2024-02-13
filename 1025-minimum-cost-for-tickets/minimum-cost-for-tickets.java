class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[]=new int[days.length+1];
        Arrays.fill(dp,-1);
        return solve(days,costs,0,dp);
    }
    public int solve(int days[], int costs[],int idx, int dp[]){
        int n=days.length;
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int option1=costs[0]+solve(days,costs,idx+1,dp);
        int i;
        for(i=idx;i<n && days[i]<days[idx]+7;i++);
        
        int option2=costs[1]+solve(days,costs,i,dp);
        
        for(i=idx;i<n && days[i]<days[idx]+30;i++);
        
        int option3=costs[2]+solve(days,costs,i,dp);
        
        return dp[idx]=Math.min(option1, Math.min(option2,option3));
    }
}