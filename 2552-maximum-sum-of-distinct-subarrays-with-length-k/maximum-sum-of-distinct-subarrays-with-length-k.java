class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        long sum=0;
        for(int i=0;i<k;i++){
           sum+=nums[i];
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.size()==k) ans=Math.max(ans,sum);
        for(int i=k;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum+=nums[i];
            sum-=nums[i-k];
            map.put(nums[i-k],map.getOrDefault(nums[i-k],0)-1);
            if(map.get(nums[i-k])<=0) map.remove(nums[i-k]);
            if(map.size()>=k)
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}