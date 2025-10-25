class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m=flowers.length;
        int n=people.length;
        
        int pf[][]=new int[2*m][2];
        for(int i=0;i<m;i++){
            int st=flowers[i][0];
            int end=flowers[i][1];

            pf[2*i][0]=st;
            pf[2*i][1]++;
            pf[2*i+1][0]=end+1;
            pf[2*i+1][1]--;

        }

        Arrays.sort(pf,(a,b)->(a[0]-b[0]));
         System.out.println(pf[0][0]+"->"+pf[0][1]);
        for(int i=1;i<2*m;i++){
            pf[i][1]+=pf[i-1][1];

            System.out.println(pf[i][0]+"->"+pf[i][1]);
            
        }

        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int k=people[i];
            ans[i]=binarySearch(pf,k);
        }

    return ans;
    }
    public int binarySearch(int pf[][], int k){
        int sz=pf.length;
        int l=0;
        int r=sz-1;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;

            if(pf[mid][0]<=k){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        if(ans==-1) return 0;
        System.out.println(pf[ans][0]);
        return pf[ans][1];
    }
}