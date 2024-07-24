class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n=nums.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            int x=0;
            int tens=1;
            int temp=nums[i];
            if(temp==0) x=mapping[0];
            while(temp>0){
                int r=mapping[temp%10];
                x+=r*tens;
                tens*=10;
                temp/=10;
            }
          arr[i][1]=x;
        }

        int ans[]=new int[n];
        Arrays.sort(arr,(a,b)->(a[1]-b[1]));
        for(int i=0;i<n;i++){
            ans[i]=arr[i][0];
        }

        return ans;
    }
}