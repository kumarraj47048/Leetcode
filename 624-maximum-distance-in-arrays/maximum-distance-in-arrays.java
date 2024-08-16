class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n=arrays.size();
        int max=0;
        int low[]=new int[n];
        int high[][]=new int[n][2];
        for(int i=0;i<n;i++){
            int sz=arrays.get(i).size();
            low[i]=arrays.get(i).get(0);
            high[i][0]=i;
            high[i][1]=arrays.get(i).get(sz-1);
        }
        Arrays.sort(high,(a,b)->(a[1]-b[1]));
        for(int i=0;i<n;i++){
            if(high[n-1][0]!=i) max=Math.max(max,Math.abs(low[i]-high[n-1][1]));
            else max=Math.max(max,Math.abs(low[i]-high[n-2][1]));
        }
        return max;
    }
}