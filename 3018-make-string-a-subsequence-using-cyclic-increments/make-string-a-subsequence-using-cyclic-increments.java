class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        char ch1[]=str1.toCharArray();
        char ch2[]=str2.toCharArray();
        int p1=0,p2=0;
        while(p1<n && p2<m){
            if((ch1[p1]-'a'+1)%26-(ch2[p2]-'a')==0 || (ch2[p2]-'a')-(ch1[p1]-'a')==0 || (ch2[p2]-'a')-(ch1[p1]-'a')==1 ){
                p2++;
            }
            p1++;
        }
        return p2>=m;
    }
}