class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int high=nums[n-1]-nums[0];
        int low=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++) low=Math.min(low,nums[i+1]-nums[i]);
        while(low<high){
            int mid=(low+high)/2;
            int temp=check(nums,k,mid);
            if(temp<k) low=mid+1;
            else high=mid;
        }
        return low;
    }
    public static int check(int nums[], int k, int diff){
        int n=nums.length;
        int ct=0;
        int p1=0;
        for(int p2=1;p2<n;p2++){
            while(nums[p2]-nums[p1]>diff) p1++;
            ct+=(p2-p1);
        }
        return ct;
    }
}