class Solution {
    public int countArrangement(int n) {
        return solve(1,new HashSet<Integer>(), n);
    }
    public int solve(int idx, HashSet<Integer> set, int n){
        if(idx==n+1) return 1;
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
        return ans;
    }
}