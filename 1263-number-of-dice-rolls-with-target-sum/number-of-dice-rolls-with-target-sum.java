class Solution {
    public static int mod=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        HashMap<String,Integer> map=new HashMap<>();
        return solve(n,k,target,map);
    }
    public static int solve(int n, int k, int target, HashMap<String,Integer> map){
        if(n==0 && target==0) return 1;
        if(n==0 || target<=0) return 0;
        String key=n+","+target;
        if(map.containsKey(key)) return map.get(key);
        int ct=0;
        for(int i=1;i<=k;i++){
            ct=(ct+solve(n-1,k,target-i,map))%mod;
        }
        map.put(key,ct);
        return ct;
    }
}