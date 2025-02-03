class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int l=1;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(func1(nums,i,j)) l=Math.max(l,j-i+1);
            }
        }
         for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(func2(nums,i,j)) l=Math.max(l,j-i+1);
            }
        }
        return l;
    }
    public boolean func1(int nums[],int i, int j){
        for(int k=i;k<j;k++){
            if(nums[k]<=nums[k+1]) return false;
        }
        return true;
    }
     public boolean func2(int nums[],int i, int j){
        for(int k=i;k<j;k++){
            if(nums[k]>=nums[k+1]) return false;
        }
        return true;
    }
}