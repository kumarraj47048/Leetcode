class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length;
        int ct[]=new int[1000002];
        for(int i=0;i<n;i++){
            int st=intervals[i][0];
            int end=intervals[i][1];
            ct[st]++;
            ct[end+1]--;
        }
        int max=1;
        for(int i=1;i<=1000000;i++){
            ct[i]+=ct[i-1];
            max=Math.max(max,ct[i]);
            //System.out.print(ct[i]+" ");
        }

    return max;
    }
}