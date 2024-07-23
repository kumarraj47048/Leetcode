class Solution {
    public int[] frequencySort(int[] nums) {
        int arr[]=new int[201];
        for(int i:nums){
            arr[i+100]++;
        }

        int ans[]=new int[nums.length];
        int idx=0;
        for(int i=1;i<=100;i++){
            for(int j=200;j>=0;j--){
                if(arr[j]==i){
                    for(int k=0;k<arr[j];k++){
                        ans[idx]=j-100;
                        idx++;
                    }
                }
            }
        }
        return ans;
    }
}