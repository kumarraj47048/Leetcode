class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        List<String> list=new ArrayList<>();
        list.add(words[0]);
        for(int i=1;i<n;i++){
            if(!check(words[i],words[i-1])) list.add(words[i]);
        }
        return list;
    }
    public boolean check(String a, String b){
        int ct[]=new int[26];
        int ct2[]=new int[26];

        for(char c:a.toCharArray()) ct[c-'a']++;
        for(char c:b.toCharArray()) ct2[c-'a']++;

        for(int i=0;i<26;i++){
            if(ct[i]!=ct2[i]) return false;
        }

        return true;
    }
}