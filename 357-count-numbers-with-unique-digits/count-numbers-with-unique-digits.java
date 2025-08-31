class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ct[]=new int[10];
        return solve(0,ct,n)+1;
    }
    public int solve(int idx, int ct[], int n){
        int ans=0;
        if(idx==n) return 0;
        for(int i=0;i<=9;i++){
            if(i==0 && idx==0) continue;
            else{
                if(ct[i]<1){
                    ct[i]++;
                    ans+=1+solve(idx+1,ct,n);
                    ct[i]--;
                }
            }
        }
        return ans;
    }
}