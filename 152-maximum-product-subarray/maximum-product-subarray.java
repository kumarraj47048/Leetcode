class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        int currProd=1;
        for(int i=0;i<n;i++){
            currProd*=nums[i];
            ans=Math.max(ans,currProd);
            if(currProd==0) currProd=1;
        }
        currProd=1;
        for(int i=n-1;i>=0;i--){
            currProd*=nums[i];
            ans=Math.max(ans,currProd);
            if(currProd==0) currProd=1;
        }
        return ans;
    }
}