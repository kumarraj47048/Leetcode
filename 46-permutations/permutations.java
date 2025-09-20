class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean used[]=new boolean[nums.length];
        solve(nums,new ArrayList<>(),used);
        return ans;
    }
    public void solve(int nums[], ArrayList<Integer> list, boolean used[]){
        int n=nums.length;
        if(list.size()==n){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<n;i++){
            if(!used[i]){
                used[i]=true;
                list.add(nums[i]);
                solve(nums,list,used);
                list.remove(list.size()-1);
                used[i]=false;
            }
        }
    }
}