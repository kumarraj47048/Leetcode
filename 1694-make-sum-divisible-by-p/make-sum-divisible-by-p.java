class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int target=0;
        for(int i:nums) target=(target+i)%p;
        target%=p;
        if(target==0) return 0;
        map.put(0,-1);
        int min=n;
        int curr=0;
        for(int i=0;i<n;i++){
            curr=(curr+nums[i])%p;
            int need=(curr-target+p)%p;
            if(map.containsKey(need)) min=Math.min(min,i-map.get(need));
            map.put(curr,i);
        }
        if(min==n) return -1;
        else return min;
    }
}