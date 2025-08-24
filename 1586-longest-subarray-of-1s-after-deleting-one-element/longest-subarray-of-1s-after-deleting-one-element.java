class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int z=0;
        int p1=0;
        int len=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) z++;
            while(p1<=i && z>1){
                if(nums[p1]==0) z--;
                p1++;
            }
            len=Math.max(len,i-p1);
        }
        return len;
    }
}