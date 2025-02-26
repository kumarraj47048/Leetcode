class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
        int arr2[]=new int[n];
        for(int i=0;i<n;i++){
            arr2[i]=-1*nums[i];
        }
        int max1=0;
        int max2=0;
        int curr=0;
        for(int i=0;i<n;i++){
           curr+=nums[i];
           if(curr<0) curr=0;
           max1=Math.max(max1,curr);
        }

        curr=0;
        for(int i=0;i<n;i++){
            curr+=arr2[i];
            if(curr<0) curr=0;
            max2=Math.max(max2,curr);
        }
        return Math.max(max1,max2);
    }
}