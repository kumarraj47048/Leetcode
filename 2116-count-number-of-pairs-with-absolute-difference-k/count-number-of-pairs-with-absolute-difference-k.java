class Solution {
    public int countKDifference(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ct=0;
        map.put(nums[0],1);
        for(int i=1;i<n;i++){
            ct+=map.getOrDefault(nums[i]+k,0)+ map.getOrDefault(nums[i]-k,0);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return ct;
    }
}