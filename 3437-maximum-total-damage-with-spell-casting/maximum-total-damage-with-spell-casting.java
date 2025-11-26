class Solution {
    public long maximumTotalDamage(int[] nums) {
        long sum=0;
        int n=nums.length;
        
       Arrays.sort(nums);
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums) map.put(x,map.getOrDefault(x,0)+1);
        
        List<Integer> list=new ArrayList<>(map.keySet());
       
        Arrays.sort(nums);
        n=list.size();
        long dp[]=new long[n+1];
        dp[0]=0;
         Collections.sort(list);
        dp[0]=(long)list.get(0)*map.get(list.get(0));
        for(int i=1;i<n;i++){
            dp[i]=(long)list.get(i)*map.get(list.get(i));
            int j=i;
            for( j=i-1;j>=0;j--){
                if(list.get(i)-list.get(j)>2){
                     break;
                }
            }
            if(j>=0) dp[i]+=dp[j];
            long temp=dp[i-1];
            dp[i]=Math.max(dp[i],temp);
        }
        
        return dp[n-1];
    }
}