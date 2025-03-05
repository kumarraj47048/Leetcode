class Solution {
    public long coloredCells(int n) {
        long ans=1;
        long four=1;
        while(n-->1){
            ans+=(four)*4;
            four++;
        }
        return ans;
    }
}