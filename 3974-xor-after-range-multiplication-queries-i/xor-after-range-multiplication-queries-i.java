class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;

        for(int i=0;i<q;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int k=queries[i][2];
            int v=queries[i][3];

            int idx=l;

            while(idx<=r){
                long temp= ((long)nums[idx]*v);
                temp= (temp%1000000007);
                nums[idx]=(int)temp;
                idx+=k;
            }
        }


        int xor=nums[0];

        for(int i=1;i<n;i++){
            xor=(xor^nums[i]);
        }


        return xor;
    }
}