class Solution {
    public int heightChecker(int[] heights) {
        int n=heights.length;
        int temp[]=new int[n];
        for(int i=0;i<n;i++) temp[i]=heights[i];
       Arrays.sort(heights);
       int ct=0;
       //for(int i:heights) System.out.print(i+" ");
       for(int i=0;i<n;i++){
        
        if(temp[i]!=heights[i]) ct++;
       }
       return ct;
    }
}