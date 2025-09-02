class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        int odd[]=new int[n+2];
        int even[]=new int[n+2];

        for(int i=n-1;i>=0;i--){
            odd[i]=odd[i+1];
            even[i]=even[i+1];
            if(i%2==0) odd[i]+=nums[i];
            else even[i]+=nums[i];
        }
           

        int ct=0;
        int x=0;
        int y=0;
        for(int i=0;i<n;i++){
            if(even[i+1]+x==odd[i+1]+y) ct++;
            if(i%2==0) x+=nums[i];
            else y+=nums[i];
        }
        return ct;
    }
}