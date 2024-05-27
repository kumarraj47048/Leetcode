class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=nums[n-1];
        for(int i=0;i<=max;i++){

            for(int k=0;k<n;k++){
                if(nums[k]>=i){
                    if(i==n-k) return i;
                    else break;
                }
            }
        }
        return -1;
    }
}