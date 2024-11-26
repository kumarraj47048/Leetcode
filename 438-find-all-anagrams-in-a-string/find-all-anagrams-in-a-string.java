class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        int n=s.length();
        int m=t.length();
        List<Integer> list=new ArrayList<>();
        if(m>n) return list;
        int ct[]=new int[26];
        int ct2[]=new int[26];
        for(int i=0;i<m;i++){
           char c=s.charAt(i);
           ct[c-'a']++;
           c=t.charAt(i);
           ct2[c-'a']++;
        }
        int idx=0;
        if(check(ct,ct2)) list.add(idx);
        for(int i=m;i<n;i++){
            char c=s.charAt(i);
            char d=s.charAt(idx);
            ct[c-'a']++;
            ct[d-'a']--;
            if(check(ct,ct2)) list.add(idx+1);
            idx++;
        }
        return list;
    }
    public static boolean check(int ct[], int ct2[]){
        for(int i=0;i<26;i++){
            if(ct[i]!=ct2[i]) return false;
        }
        return true;
    }
}