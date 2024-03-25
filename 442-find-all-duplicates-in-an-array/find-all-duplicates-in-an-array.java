class Solution {
    public List<Integer> findDuplicates(int[] nums) {
     boolean mark[]=new boolean[nums.length];
     List<Integer> list=new ArrayList<>();
     for(int i=0;i<nums.length;i++){
         int index=nums[i]-1;
         if(mark[index]==false)
           mark[index]=true;
           else
           list.add(nums[i]);
     }
      return list;
    }
}