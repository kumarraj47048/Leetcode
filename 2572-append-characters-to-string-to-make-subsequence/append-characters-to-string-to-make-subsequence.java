class Solution {
    public int appendCharacters(String s, String t) {
        int n=s.length();
        int m=t.length();
        int p1=0;
        int p2=0;
        int ct=0;
        char cS[]=new char[n];
        cS=s.toCharArray();
        char cT[]=new char[m];
        cT=t.toCharArray();
        while(p1<n && p2<m){
            if(cS[p1]==cT[p2]){
                p1++;
                p2++;
            }else p1++;
        }
        
        return m-p2;
    }
}