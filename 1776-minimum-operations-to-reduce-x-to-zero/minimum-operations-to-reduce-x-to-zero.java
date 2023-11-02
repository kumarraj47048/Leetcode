class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int target=-x;
       // int target=0;
        for(int i=0;i<n;i++){
            target+=nums[i];
        }
        
        if(target==0) return n;
        
        int currSum=0;
        int left=0;
        int maxL=0;
        
        for(int right=0;right<nums.length;right++){
             currSum+=nums[right];
            while(left<=right && currSum>target){
                currSum-=nums[left];
                left++;
            }
            
            if(currSum==target){
                maxL=Math.max(maxL,right-left+1);
            }
        }
        if(maxL==0) return -1;
        else return n-maxL;
    }
}