class Solution {
    public int m,n;
    public int mod=1000000007;
    public HashMap<String,Integer> map=new HashMap<>();
    public int findPaths(int M, int N, int maxMove, int startRow, int startColumn) {
        m=M;
        n=N;
        
        return solve(startRow,startColumn,maxMove);
    }
    public int solve(int r, int c, int steps){
        if(r<0 || r>=m || c<0 || c>=n) return 1;
        if(steps<=0) return 0;
        String key=r+","+c+","+steps;
        if(map.containsKey(key)) return map.get(key);
        int res=0;
        res=(res+solve(r-1,c,steps-1))%mod;
        res=(res+solve(r,c-1,steps-1))%mod;
        res=(res+solve(r+1,c,steps-1))%mod;
        res=(res+solve(r,c+1,steps-1))%mod;
        map.put(key,res);
        return res;
    }
}