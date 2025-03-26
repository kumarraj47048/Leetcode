class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        ArrayList<int[]> list=new ArrayList<>();
        int curr[]=intervals[0];
        list.add(curr);
        for(int i[]:intervals){
            if(i[0]<=curr[1]){
                curr[0]=Math.min(i[0],curr[0]);
                curr[1]=Math.max(i[1],curr[1]);
            }
            else{
                curr=i;
                list.add(curr);  
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}