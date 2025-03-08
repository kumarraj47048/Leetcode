class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        char ch[]=blocks.toCharArray();
       
        int w=0,b=0;
        int ct=n+1;
        for(int i=0;i<k;i++){
            if(ch[i]=='W') w++; 
        }
        ct=Math.min(ct,w);
        System.out.println(ct);
        for(int i=k;i<n;i++){
            if(ch[i]=='W') w++;
            if(ch[i-k]=='W') w--;
            ct=Math.min(ct,w);
        }
        return ct;
    }
}