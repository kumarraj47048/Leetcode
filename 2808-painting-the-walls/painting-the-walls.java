class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        HashMap<String,Integer> map=new HashMap<>();
        return solve(0,cost.length,cost,time,map);
    }
    public static int solve(int idx, int left, int cost[], int time[], HashMap<String,Integer> map){
        int n=cost.length;
        if(left<0) left=0;
        if(idx>=n){
            if(left<=0) return 0;
            else return Integer.MAX_VALUE/2;
        }
        String key=idx+","+left;
        if(map.containsKey(key)) return map.get(key);
        int pick=cost[idx]+solve(idx+1,left-time[idx]-1,cost,time,map);
        int not_pick=solve(idx+1,left,cost,time,map);
        int val=Math.min(pick,not_pick);
        map.put(key,val);
        return val;

    }
}