class Solution {
    public long numberOfWays(String s) {
        int n=s.length();
        long dp[][][]=new long[n][4][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(0,s.toCharArray(),'2',3,dp);
    }
    public long solve(int idx, char ch[], char prev, int steps, long dp[][][]){
        long ct=0;
        if(steps<=0) return 1;
        if(idx>=ch.length) return 0;
        //String key=idx+","+prev+","+steps;
       // if(map.containsKey(key)) return map.get(key);
        if(dp[idx][steps][prev-'0']!=-1) return dp[idx][steps][prev-'0'];
        if(ch[idx]!=prev){
            ct+=solve(idx+1,ch,ch[idx],steps-1,dp);
            ct+=solve(idx+1,ch,prev,steps,dp);
        }
        else{
            ct+=solve(idx+1,ch,prev,steps,dp);
        }
       // map.put(key,ct);
        return dp[idx][steps][prev-'0']=ct;
    }
}