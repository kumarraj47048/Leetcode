class Solution {
    public int[] countBits(int n) {
        int ar[]=new int[n+1];
        for(int i=0;i<=n;i++){
            int k=i;
            int ct=0;
            while(k!=0){
              ct+=k&1;
               k=k>>1;
            }
            ar[i]=ct;
        }
        return ar;
    }
}