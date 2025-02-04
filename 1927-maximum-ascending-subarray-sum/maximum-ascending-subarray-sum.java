class Solution {
    public int maxAscendingSum(int[] nums) {
        int n=nums.length;
        int len=0;
       
        if(n==1) return nums[0];
        int temp=nums[0];
        len=temp;
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                temp+=nums[i];
            }
            else{
                temp=nums[i];
            }
            len=Math.max(len,temp);
        }
        return len;
    }

}