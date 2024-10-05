class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int ct[]=new int[26];
        int n=s2.length();
        char ch[]=s2.toCharArray();
      
        for(char c:s1.toCharArray())
            ct[c-'a']++;
       for(int i=0;i<n;i++){
           int ct2[]=new int[26];
           for(int j=i;j<n;j++){
               
           char c=ch[j];
           ct2[c-'a']++;
           if(check(ct,ct2)) return true;
               }
       }
        return false;
    }
    public static boolean check(int ct[], int ct2[]){
        for(int i=0;i<26;i++){
            if(ct[i]!=ct2[i]) return false;
        }
        return true;
    }
}