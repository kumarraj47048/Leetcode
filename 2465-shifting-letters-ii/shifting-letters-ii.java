class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int pf[]=new int[n+1];
        for(int i[]:shifts){
            int start=i[0];
            int end=i[1];
            int op=0;
            if(i[2]==0)  op=-1;
            else  op=1;
            pf[start]+=op;
            pf[end+1]+=(-1*op);
        }
        for(int i=1;i<=n;i++){
            pf[i]+=pf[i-1];
        }
        char ch[]=s.toCharArray();
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<n;i++){
            int shift=(pf[i])%26;
            shift+=26;
            shift%=26;
           
            sb.append((char)((ch[i]-'a'+shift)%26+'a'));
        }

        return sb.toString();
    }
}