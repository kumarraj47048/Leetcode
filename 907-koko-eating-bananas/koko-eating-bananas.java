class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n=piles.length;
        int ans=1;
        int left=1;
        int right=piles[n-1];
        int mid=1;
        while(left<=right){
             mid=(left+right)/2;
            if(check(piles,h,mid)){
                if(mid-1>0 && !check(piles,h,mid-1)) return mid;
            
                right=mid-1;
                ans=mid;
                
                }
            else left=mid+1;
        }
        return ans;
    }
    public boolean check(int piles[],int h, int k){
          int n=piles.length;
          int sum=0;
          for(int i=0;i<n;i++){
            sum+=piles[i]/k;
            if(piles[i]%k>0) sum++;
          }
          return sum<=h;
    }
}