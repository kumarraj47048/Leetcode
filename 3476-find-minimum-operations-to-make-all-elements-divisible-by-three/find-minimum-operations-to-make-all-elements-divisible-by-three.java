class Solution {
    public int minimumOperations(int[] nums) {
        int ct=0;
        for(int i:nums){
            ct+=Math.min(i%3,3-(i%3));
        }
        return ct;
    }
}