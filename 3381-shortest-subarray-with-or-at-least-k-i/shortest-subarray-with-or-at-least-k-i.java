class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int l=n+1;
        for(int i=0;i<n;i++){
            int or=0;
            for(int j=i;j<n;j++){
                or=or|nums[j];
                if(or>=k) l=Math.min(l,j-i+1);
            }
        }
        if(l==n+1) return -1;
        else return l;
    }
}