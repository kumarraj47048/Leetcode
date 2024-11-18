class Solution {
    public int[] decrypt(int[] code, int k) {
        int ans[]=new int[code.length];
        if(k==0) return ans;
        int start=1,end=k,sum=0;
        if(k<0){
            start=code.length-Math.abs(k);
            end=code.length-1;
        }
        int n=code.length;
        for(int i=start;i<=end;i++) sum+=code[i];
        for(int i=0;i<code.length;i++){
            ans[i]=sum;
            sum-=code[start%n];
            sum+=code[(end+1)%n];
            start++;
            end++;
        }
        return ans;
    }
}