class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
         help(nums,0,list,new ArrayList<>());
        return list;
    }
    public static void help(int nums[], int idx, List<List<Integer>> list, ArrayList<Integer> inList){
        if(idx>=nums.length){
            list.add(new ArrayList<>(inList));
            return;
        }
        inList.add(nums[idx]);
        help(nums,idx+1,list,inList);
        inList.remove(inList.size()-1);
        help(nums,idx+1,list,inList);
    }
}