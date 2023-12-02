class Solution {
    public int countCharacters(String[] words, String chars) {
        int n=chars.length();
        int ct[]=new int[26];
        // for(int i=0;i<n;i++) ct[chars.charAt(i) -'a']++;
        
        int ans=0;
        for(int i=0;i<words.length;i++) {
            Arrays.fill(ct,0);
             for(int j=0;j<n;j++) ct[chars.charAt(j) -'a']++;
            ans+=func(words[i],ct);
        }
        return ans;
    }
    private int func(String s, int ct[]) {
        for(int i=0;i<s.length();i++){
            if(ct[s.charAt(i)-'a']==0) return 0;
            else ct[s.charAt(i)-'a']--;
        }
        return s.length();
    }
}