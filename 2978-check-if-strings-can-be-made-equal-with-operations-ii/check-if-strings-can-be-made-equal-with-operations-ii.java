class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();
        int ct1[]=new int[26];
        int ct2[]=new int[26];

        for(int i=0;i<n;i+=2){
            ct1[c1[i]-'a']++;
            ct2[c2[i]-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ct1[i]!=ct2[i]) return false;
        }

        Arrays.fill(ct1,0);
        Arrays.fill(ct2,0);



        for(int i=1;i<n;i+=2){
            ct1[c1[i]-'a']++;
            ct2[c2[i]-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ct1[i]!=ct2[i]) return false;
        }


    return true;

    }
}