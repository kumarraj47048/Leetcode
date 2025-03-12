class Solution {
    public int maximumCount(int[] nums) {
        int a=0;
        int b=0;
        for(int i:nums){
            if(i<0) a++;
            else if(i>0) b++;
        }
        return Math.max(a,b);
    }
}