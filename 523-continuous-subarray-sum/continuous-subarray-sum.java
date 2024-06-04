class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(nums[0]%k,0);
        int sum=nums[0];
        for(int i=1;i<n;i++){
            sum+=nums[i];
            int r=sum%k;
            if(r==0 && i>0) return true;
            if(map.containsKey(r)){
                if(i-map.get(r)>1) return true;
            }
            else map.put(r,i);
        }
        return false;
    }
}