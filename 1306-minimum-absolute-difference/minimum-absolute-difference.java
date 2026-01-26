class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int diff=Integer.MAX_VALUE;
        for(int i=1;i<n;i++) diff=Math.min(diff, arr[i]-arr[i-1]);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]==diff){
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }

        return ans;
    }
}