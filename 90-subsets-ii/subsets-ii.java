class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        help(nums,0,list,new ArrayList<>(),set);
        return list;
    }
    public static void help(int nums[], int idx, List<List<Integer>> list, ArrayList<Integer> inList,HashSet<List<Integer>> set){
        if(idx>=nums.length){
            if(!set.contains(inList)){
                list.add(new ArrayList<>(inList));
                set.add(inList);
            }
            return;
        }
        inList.add(nums[idx]);
        help(nums,idx+1,list,inList,set);
        inList.remove(inList.size()-1);
        help(nums,idx+1,list,inList,set);
    }
}