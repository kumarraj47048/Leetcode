class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ct=0;
        int currSum=0;
        for(int i=0;i<n;i++){
           currSum+=nums[i];
           if(currSum==k) ct+=map.getOrDefault(0,0)+1;
           else{
            if(map.containsKey(currSum-k)) ct+=map.get(currSum-k);
           }
           map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return ct;
    }
}