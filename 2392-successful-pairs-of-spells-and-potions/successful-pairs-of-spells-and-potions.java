class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=potions.length;
        Arrays.sort(potions);
        
        int ans[]=new int[spells.length];
        for(int i=0;i<spells.length;i++){
            ans[i]=binarySearch(spells[i],potions,success);
        }

        return ans;

    }
    public static int binarySearch(int k, int potions[], long success){

        int n=potions.length;
        int l=0;
        int r=n-1;

        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            long x=(long)potions[mid]*k;
            if(x>=success){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }

        if(ans==-1) return 0;
        else return n-ans;
    }
}