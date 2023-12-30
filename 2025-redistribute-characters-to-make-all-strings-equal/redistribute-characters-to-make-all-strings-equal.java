class Solution {
    public boolean makeEqual(String[] words) {
        int n=words.length;
        int ch[]=new int[26];
        for(int i=0;i<n;i++){
            String s=words[i];
            for(int j=0;j<s.length();j++){
                ch[s.charAt(j)-'a']++;
            }
        }
       // int target=ch[words[0].charAt(0)-'a'];
        for(int i=0;i<26;i++){
           if(ch[i]%n!=0 && ch[i]>0) return false;
        }
        return true;
    }
}