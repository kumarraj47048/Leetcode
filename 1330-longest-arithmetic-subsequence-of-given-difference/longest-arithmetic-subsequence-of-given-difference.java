class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n=arr.length;
        int len=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
           int temp=map.getOrDefault(arr[i]-difference,0)+1;
           map.put(arr[i],temp);
           len=Math.max(temp,len);
        }
        return len;
    }
}