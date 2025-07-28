class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i:nums) max=max|i;
        //int dp[]=new int[n];
        HashMap<String,Integer> map=new HashMap<>();
        //Arrays.fill(dp,-1);
        return solve(0,0,nums,max,map);
    }
    public int solve(int idx,int curr, int nums[], int max, HashMap<String,Integer> map){
        int n=nums.length;
        if(idx>=n){
            if(curr==max) return 1;
            else return 0;
        }
        String key=idx+","+curr;
        if(map.containsKey(key)) return map.get(key);
       // if(dp[idx]!=-1) return dp[idx];
        int x=solve(idx+1,curr|nums[idx],nums,max,map) + solve(idx+1,curr,nums,max,map);
        map.put(key,x);
        return x;
    }
}