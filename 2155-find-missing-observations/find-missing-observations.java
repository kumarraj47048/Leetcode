class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int ans[]=new int[n];
        int m=rolls.length;
        int sum=0;
        System.out.println(m+" ");
        for(int i:rolls) sum+=i;
        System.out.println(sum+" ");
        int rem=(mean*(n+m))-sum;
        System.out.println(mean*(n+m)+" ");
        System.out.println(rem);
        if(n*6<rem || rem<=0 || rem<n) return new int[]{};
        for(int i=0;i<n;i++) ans[i]++;
        rem-=n;
        for(int i=0;i<n;i++){
            for(int k=0;k<5;k++){
                if(rem>0){
                    ans[i]++;
                    rem--;
                }
            }
        }
        return ans;
    }
}