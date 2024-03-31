class Solution {
    public int minimumLevels(int[] possible) {
        int n=possible.length;
        int pf[]=new int[n];
        if(possible[0]==1)
        pf[0]=possible[0];
        else pf[0]=-1;
        for(int i=1;i<n;i++){
            if(possible[i]==0){
                pf[i]=pf[i-1]-1;
            }
            else pf[i]=pf[i-1]+1;
        }

        for(int i=0;i<n-1;i++){
            if(pf[i]>pf[n-1]-pf[i]) return i+1;
        }
        return -1;
    }
}