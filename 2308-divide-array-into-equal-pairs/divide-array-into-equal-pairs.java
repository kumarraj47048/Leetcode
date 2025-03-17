class Solution {
    public boolean divideArray(int[] nums) {
        int n=nums.length;
        int ct[]=new int[501];
        for(int i:nums) ct[i]++;
        for(int i:ct){
            if(i%2==1) return false;
        }
        return true;
    }
}