class Solution {
   // int dp[];
   HashMap<String,Integer> map=new HashMap<>();
    public int countArrangement(int n) {
       // dp=new int[n+1];
        //Arrays.fill(dp,-1);
        return solve(1,new HashSet<Integer>(), n);
    }
    public int solve(int idx, HashSet<Integer> set, int n){
        if(idx==n+1) return 1;
        String key=idx+","+set;
        if(map.containsKey(key)) return map.get(key);
        //if(dp[idx]!=-1) return dp[idx];
        int ans=0;
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                if(i%idx==0 || idx%i==0){
                    set.add(i);
                    ans+=solve(idx+1,set,n);
                    set.remove(i);
                }
            }
        }
        map.put(key,ans);
        return ans;
    }
}