class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        int arr[]=new int[n];
        int min=24*60+10;
        int idx=0;
        for(String s:timePoints){
            int hh=Integer.parseInt(s.substring(0,2));
            int mm=Integer.parseInt(s.substring(3));
            arr[idx++]=hh*60+mm;
        }
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            min=Math.min(min,arr[i+1]-arr[i]);
        }
        min=Math.min(min,24*60+arr[0]- arr[n-1]);
        return min;
    }
}