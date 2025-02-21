class Solution {
    public int maxValue(int[][] events, int k) {
        int n=events.length;
        Arrays.sort(events,(a,b)->(a[0]-b[0]));
        int dp[][]=new int[n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,k,events,dp);
    }
    public static int solve(int idx, int k, int events[][], int dp[][]){
        if(k==0 || idx>=events.length) return 0;
        if(dp[idx][k]!=-1) return dp[idx][k];
        int skip=solve(idx+1,k,events,dp);
        int take=0;
        int nextIdx=idx+1;
        while(nextIdx<events.length && events[idx][1]>=events[nextIdx][0]){
            nextIdx++;
        }
         take=events[idx][2]+solve(nextIdx,k-1,events,dp);
         
        return dp[idx][k]=Math.max(take,skip);
    }
}