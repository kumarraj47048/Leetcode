class Solution {
    public int minOperations(int[] nums, int k) {
        int ct=0;
        int n=nums.length;
        for(int i=30;i>=0;i--){
            int x=0;
            for(int j=0;j<n;j++){
                x^=(nums[j]>>i)&1;
            }
            if((x)!=((k>>i)&1)) ct++;
        }
        return ct;
    }
}
