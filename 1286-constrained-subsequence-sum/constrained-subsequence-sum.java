class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n=nums.length;
        int dp[]=new int[n];
        int result=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     dp[i]=nums[i];
        //     result=Math.max(result,dp[i]);
        // }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{dp[0],0});
        for(int i=0;i<n;i++){
            dp[i]=nums[i];
            while(pq.size()>0 && pq.peek()[1]<i-k) pq.poll();
            dp[i]=Math.max(dp[i],nums[i]+pq.peek()[0]);
            pq.add(new int[]{dp[i],i});
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}