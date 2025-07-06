class Solution {
    HashMap<String,Integer> map;
    public int minTaps(int n, int[] ranges) {
        int ran[][]=new int[n+1][2];
        for(int i=0;i<=n;i++){
            ran[i][0]=Math.max(0,i-ranges[i]);
            ran[i][1]=Math.min(n,i+ranges[i]);
        }
        map=new HashMap<>();
        Arrays.sort(ran,(a,b)->(a[0]-b[0]));
       int ans=solve(0,ran,0);
       if(ans==1000000) return -1;
       else return ans;   
    }
    public int solve(int idx,int ran[][], int maxEnd){
        if(idx>=ran.length && maxEnd>=ran.length-1) return 0;
        if(idx>=ran.length && maxEnd<ran.length-1) return 1000000;
        if(maxEnd<ran[idx][0]) return 1000000;
        String key=idx+" "+maxEnd;
        if(map.containsKey(key)) return map.get(key);

        int not_pick=solve(idx+1,ran,maxEnd);
        int pick=1+solve(idx+1,ran,Math.max(maxEnd,ran[idx][1]));
        map.put(key,Math.min(not_pick,pick));
        return Math.min(not_pick,pick);
        
    }
}
