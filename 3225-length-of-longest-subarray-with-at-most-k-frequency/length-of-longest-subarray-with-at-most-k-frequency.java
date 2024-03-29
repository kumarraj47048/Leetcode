class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int i=0;
        int j=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<n){
           int curr=nums[j];
           j++;
           map.put(curr,map.getOrDefault(curr,0)+1);
           while(i<j && map.get(curr)>k){
               map.put(nums[i],map.get(nums[i])-1);
               i++;
           }
           l=Math.max(l,j-i);
        }
        return l;
    }
}