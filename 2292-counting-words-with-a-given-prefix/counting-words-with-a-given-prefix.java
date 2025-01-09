class Solution {
    public int prefixCount(String[] words, String pref) {
        int n=words.length;
        int ct=0;
        int l=pref.length();
        for(String s:words){
            if(l<=s.length() && s.substring(0,l).equals(pref)) ct++;
        }
        return ct;
    }
}