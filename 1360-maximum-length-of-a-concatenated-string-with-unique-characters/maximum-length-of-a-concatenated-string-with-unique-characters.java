class Solution {
    public int maxLength(List<String> arr) {
        int n=arr.size();
        int length=Math.max(rec(arr,0,""), rec(arr,0,arr.get(0)));
        return length;
    }
    private int rec(List<String> arr, int idx,String s){
        int n=arr.size();
        if(idx>=n){
            if(check(s)) return s.length();
            else return 0;
        }
        return Math.max(rec(arr,idx+1,s+(arr.get(idx))),rec(arr,idx+1,s));
    }
    private boolean check(String s){
        int ct[]=new int[26];
        for(char c:s.toCharArray()) ct[c-'a']++;
        for(int i=0;i<26;i++) if(ct[i]>1) return false;
        return true;
    }
}