class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int len=0;
        int p1=0;
        int n=nums.length;

        for(int i=1;i<n;i++){
            while(p1<i && nums[i]-nums[p1]>1){
                p1++;
            }
            if(nums[i]-nums[p1]==1)
            len=Math.max(len,i-p1+1);
        }

        return len;
    }
}