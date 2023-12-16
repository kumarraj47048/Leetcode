class Solution {
    public boolean isAnagram(String s, String t) {
        int ct[]=new int[26];
        int ct2[]=new int[26];
        for(int i=0;i<s.length();i++){
            ct[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            ct2[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ct[i]!=ct2[i]) return false;
        }
        return true;
    }
}