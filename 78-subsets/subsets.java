class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList<>();
        solve(0,nums,new ArrayList<>());
        return ans;
    }
    public void solve(int idx, int nums[], List<Integer> list){
        int n=nums.length;
        if(idx==n){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        solve(idx+1,nums,list);
        list.remove(list.size()-1);
        solve(idx+1,nums,list);
    }
}