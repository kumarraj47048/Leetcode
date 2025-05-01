class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int min=n+1;
        int sum=0;
        int len=0;
        int p1=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            len++;
            if(sum>=target) min=Math.min(len,min);
            while(p1<=i && sum>=target){
                sum-=nums[p1];
                len--;
                if(sum>=target)
                min=Math.min(len,min);
                p1++;
            }
        }
        if(min==n+1) return 0;
        return min;
    }
}