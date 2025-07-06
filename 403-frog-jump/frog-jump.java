class Solution {
    public boolean canCross(int[] stones) {
       if(stones[1]!=1) return false;
       int n=stones.length;
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<n;i++){
           map.put(stones[i],i);
       }
       Boolean dp[][]=new Boolean[2001][2001];
       return solve(1,stones,1,map,dp);       
    }
    public static boolean solve(int idx, int stones[], int k, HashMap<Integer,Integer> map, Boolean dp[][]){
        int n=stones.length;
        if(k<=0) return false;
        if(idx==n-1) return true;
        if(idx>=n) return false;
        boolean res=false;
        if(dp[idx][k]!=null) return dp[idx][k];
       
        if(map.containsKey(stones[idx]+k-1))
         res=res||solve(map.get(stones[idx]+k-1),stones,k-1,map,dp);

        if(map.containsKey(stones[idx]+k))
         res=res||solve(map.get(stones[idx]+k),stones,k,map,dp);

        if(map.containsKey(stones[idx]+k+1))
         res=res||solve(map.get(stones[idx]+k+1),stones,k+1,map,dp);


        // p1=idx+1;
        //  while(p1<n){
        //     if(stones[idx]+k==stones[p1]) break;
        //     p1++;
        // }
        // if(p1<n){
        //     res=res||solve(p1,stones,k);
        // }


        // p1=idx+1;
        //  while(p1<n){
        //     if(stones[idx]+k+1==stones[p1]) break;
        //     p1++;
        // }
        // if(p1<n){
        //     res=res||solve(p1,stones,k+1);
        // }

       return dp[idx][k]=res;

    }
}