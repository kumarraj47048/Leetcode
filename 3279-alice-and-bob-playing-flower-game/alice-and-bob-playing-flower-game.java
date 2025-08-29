class Solution {
    public long flowerGame(int n, int m) {
        long ans=0;
        for(int i=1;i<=n;i++){
            if(i%2==0){
                ans+=m/2;
                ans+=m%2;
            }
            else ans+=m/2;
        }
        return ans;
    }
}