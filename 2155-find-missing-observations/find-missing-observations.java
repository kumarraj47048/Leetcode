class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int ans[]=new int[n];
        int m=rolls.length;
        int sum=0;
        for(int i:rolls) sum+=i;
        int rem=(mean*(n+m))-sum;
        if(n*6<rem || rem<=0 || rem<n) return new int[]{};
        for(int i=0;i<n;i++) ans[i]++;
        rem-=n;
        for(int i=0;i<n;i++){
            // for(int k=0;k<5;k++){
            //     if(rem>0){
            //         ans[i]++;
            //         rem--;
            //     }
            // }
            if(rem-5>=0){
                ans[i]+=5;
                rem-=5;
            }
            else{
                ans[i]+=rem;
                rem=0;
            }
        }
        return ans;
    }
}