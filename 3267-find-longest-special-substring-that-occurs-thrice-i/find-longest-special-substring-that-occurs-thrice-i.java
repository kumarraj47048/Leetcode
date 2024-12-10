class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        int max=-1;
        for(int i=97;i<97+26;i++){
            char ch=(char)i;
            
            
            for(int len=1;len<=n;len++){
                String temp="";
                int curr=0;
                for(int step=1;step<=len;step++){
                    temp=temp+ch;
                }
                System.out.print(temp+" ");
                for(int k=0;k<=n-len;k++){
                    if(s.substring(k,k+len).equals(temp)) curr++;
                }
                if(curr>=3) max=Math.max(max,len);
            }
        }
        return max;
    }
}