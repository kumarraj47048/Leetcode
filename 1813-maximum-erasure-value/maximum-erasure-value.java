class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        int ct[]=new int[10001];
        int curr_sum=0;
        int max_sum=0;
        int p1=0;
        for(int i=0;i<n;i++){
            int x=nums[i];
            ct[x]++;
            curr_sum+=x;
            while(p1<i && ct[x]>1){
                int y=nums[p1];
                curr_sum-=y;
                ct[y]--;
                p1++;
            }

            max_sum=Math.max(max_sum, curr_sum);
        }

        return max_sum;
    }
}