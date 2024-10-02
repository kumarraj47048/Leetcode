class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        if(n==0) return new int[]{};
        HashMap<Integer,Integer> map=new HashMap<>();
        int temp[]=new int[n];
        for(int i=0;i<n;i++) temp[i]=arr[i];
        Arrays.sort(arr);
        int rank=1;
        map.put(arr[0],rank);
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[i-1]) rank++;
            map.put(arr[i],rank);
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=map.get(temp[i]);
        }
        return ans;
    }
}