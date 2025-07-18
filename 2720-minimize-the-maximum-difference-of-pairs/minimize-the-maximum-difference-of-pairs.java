class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left=0, right=nums[nums.length-1]-nums[0];

        while(left<right){
            int mid=(left+right)/2;
            if(pairs(nums,mid,p)) right=mid;
            else  left=mid+1;
        }
        return left;
    }

    public static boolean pairs(int nums[], int mid, int p){
        int count=0;
        for(int i=0;i<nums.length-1 && count<p;){
            if(nums[i+1]-nums[i]<=mid){
                count++;
                i+=2;
            }
            else i++;
        }
        return count>=p;
    }
}