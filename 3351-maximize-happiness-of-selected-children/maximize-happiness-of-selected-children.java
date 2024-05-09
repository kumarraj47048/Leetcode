class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum=0;
        int n=happiness.length;
        int st=0;
        for(int i=n-1;i>=n-k;i--){
            if(happiness[i]-st>=0) sum+=happiness[i]-st;
            st++;
        }
        return sum;
    }
}