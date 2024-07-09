class Solution {
    public double averageWaitingTime(int[][] nums) {
        int n=nums.length;
        int ct=0;
        int pf[]=new int[n];
        pf[0]=nums[0][0]+nums[0][1]; 
        for(int i=1;i<n;i++){
            if(pf[i-1]<=nums[i][0]){
                pf[i]=nums[i][0]+nums[i][1];
            }
            else{
                pf[i]=pf[i-1]+nums[i][1];
            }
        }

        double sum=0;
        for(int i=0;i<n;i++){
            System.out.print(pf[i]-nums[i][0]+" ");
            sum=sum+(double)pf[i]-(double)nums[i][0];
        }
        return (double)(sum/n);
    }
}