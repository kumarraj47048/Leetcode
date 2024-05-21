class Solution {
    public List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> list=new ArrayList<>();
     List<Integer> in=new ArrayList<>();
     rec(nums,0,list,in);
     return list;
    }
    public static void rec(int nums[],int i,List<List<Integer>> list, List<Integer> in ){
         if(i==nums.length){
            list.add(new ArrayList<>(in));
            return;
         }
         in.add(nums[i]);
         rec(nums,i+1,list,in);
         in.remove(in.size()-1);
         rec(nums,i+1,list,in);
         return;
    }
}