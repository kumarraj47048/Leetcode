class Solution {
    public int findMaxLength(int[] nums) {
        int maxL=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
             if(nums[i]==0)
                sum=sum-1;
             else
                sum=sum+1;
          if(hm.containsKey(sum)){
              int idx=hm.get(sum);
              int len=i-idx;
             if(len>maxL){
                 maxL=len;
             }

          }
          else{
              hm.put(sum,i);
          }

        }
        return maxL;
    }
}