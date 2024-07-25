class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        int ct[]=new int[100001];
        for(int i:nums){
            ct[i+50000]++;
        }
        int ans[]=new int[n];
        int idx=0;
        for(int i=0;i<=100000;i++){
            for(int j=0;j<ct[i];j++){
                ans[idx]=i-50000;
                idx++;
            }
        }
        return ans;
    }
}