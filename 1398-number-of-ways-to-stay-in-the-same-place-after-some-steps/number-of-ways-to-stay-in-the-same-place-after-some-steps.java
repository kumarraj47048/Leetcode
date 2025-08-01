class Solution {
    public int numWays(int steps, int arrLen) {
        HashMap<String,Integer> map=new HashMap<>();
        return solve(0,steps,arrLen,map);
    }
    public int solve(int pos, int steps, int arrLen, HashMap<String,Integer> map){
        int mod=1000000007;
        if(steps==0){
            if(pos==0) return 1;
            else return 0;
        }
        String key=pos+","+steps;
        if(map.containsKey(key)) return map.get(key);
        int x=0;
        if(pos-1>=0) x=(x+solve(pos-1,steps-1,arrLen,map))%mod;
                     x=(x+solve(pos,steps-1,arrLen,map))%mod;
        if(pos+1<arrLen) x=(x+solve(pos+1,steps-1,arrLen,map))%mod;
        map.put(key,x%mod);
        return x%mod;
    }
}