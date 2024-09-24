class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n=arr.length;
        HashSet<Integer> res=new HashSet<>();
        HashSet<Integer> prev=new HashSet<>();
        for(int i=0;i<n;i++){
            int num=arr[i];
            HashSet<Integer> curr=new HashSet<>();
            curr.add(num);
            for(int x:prev) curr.add(x|num);
            for(int x:curr) res.add(x);
            prev=curr;
        }
        return res.size();
    }
}