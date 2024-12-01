class Solution {
    public boolean checkIfExist(int[] arr) {
        int n=arr.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(2*arr[i])) return true;
            set.add(arr[i]);
        }
        set.clear();
        for(int i=n-1;i>=0;i--){
             if(set.contains(2*arr[i])) return true;
            set.add(arr[i]);
        }
        return false;
    }
}