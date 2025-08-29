class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    public int waysToReachStair(int k) {
        return solve(1,0,k,1);
    }
    public int solve(int pos, int jump, int k, int back){

        if(pos>k+1) return 0;
        String key=pos+","+jump+","+back;
        if(map.containsKey(key)) return map.get(key);
        int ans=0;
        if(pos==k) ans++;
        ans+=solve(pos+(1<<jump),jump+1,k,1);
        if(pos!=0 && back==1){
            ans+=solve(pos-1,jump,k,0);
        }
        map.put(key,ans);
        return ans;
    }
}