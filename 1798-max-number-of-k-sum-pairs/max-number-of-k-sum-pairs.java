class Solution {
    public int maxOperations(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ct=0;
        for(int i=0;i<n;i++){
            int rhs=k-nums[i];
            if(map.containsKey(rhs)){
                ct++;
                map.put(rhs,map.get(rhs)-1);
                if(map.get(rhs)==0) map.remove(rhs);
            }
            else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return ct;
    }
}