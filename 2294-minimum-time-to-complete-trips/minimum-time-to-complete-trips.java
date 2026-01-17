class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low=1;
        long high=(long)1e16+7;

        long ans=(long)1e16+7;

        while(low<high){
            long mid=(low+high)/2;

            if(bs(mid,time,totalTrips)){
                ans=mid;
                high=mid;
            }
            else low=mid+1;
        }

        return ans;
    }
    public boolean bs(long t, int time[], int totalTrips){
        int n=time.length;
        long ct=0;
        for(int i=0;i<n;i++){
            ct+=(t/time[i]);
            if(ct>=totalTrips) return true;
        }
        return ct>=totalTrips;
    }
}