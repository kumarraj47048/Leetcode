class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int ct=0;
        for(int i=0;i<26;i++){
            int start=0;
            while(start<n){
                if(s.charAt(start)-'a'==i) break;
                start++;
            }
            start++;
            HashSet<Integer> set=new HashSet<>();
            int end=n-1;
            while(end>start){
                if(s.charAt(end)-'a'==i) break;
                end--;
            }
            while(start<end){
                set.add(s.charAt(start)-'a');
                start++;
            }
            ct+=set.size();

        }
    return ct;
    }
}