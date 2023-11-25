class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
      int n=nums.length;
      int pF[]=new int[n];
      pF[0]=nums[0];
      for(int i=1;i<n;i++){
          pF[i]=pF[i-1]+nums[i];
      }

      int ans[]=new int[n];

      for(int i=0;i<n;i++){
          int leftSum=pF[i]-nums[i];
          int rightSum=pF[n-1]-pF[i];

          int left=Math.abs(leftSum-(i)*(nums[i]));
          int right=Math.abs(rightSum- (n-i-1)*(nums[i]));

          ans[i]=left+right;
      }
      return ans;
    }
}