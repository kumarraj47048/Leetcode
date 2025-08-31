class Solution {
    HashMap<String,Integer> map=new HashMap<>();
    public int wiggleMaxLength(int[] nums) {
        int positive=solve(0,true,-1,nums);
        int negative=solve(0,false,10000,nums);
        return Math.max(positive,negative);
    }
    public int solve(int idx, boolean neg, int prev, int nums[]){
        
        if(idx==nums.length) return 0;
        String key=idx+","+neg+","+prev;
        if(map.containsKey(key)) return map.get(key);
        int take=0;
        int not_take=0;
        if(neg){
            if(nums[idx]-prev>0) take=1+solve(idx+1,false,nums[idx],nums);
            not_take=solve(idx+1,neg,prev,nums);
        }else{
            if(nums[idx]-prev<0) take=1+solve(idx+1,true,nums[idx],nums);
            not_take=solve(idx+1,neg,prev,nums);
        }
        map.put(key,Math.max(take,not_take));
        return Math.max(take,not_take);
    }
}