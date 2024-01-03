class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int row=bank.length;
        int ctR=0;
       
        int prev=0;
        for(int i=0;i<row;i++){
             ctR=0;
            String s=bank[i];
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='1') ctR++;
            }
            if(ctR>0){
                ans+=(ctR*prev);
                prev=ctR;
            }
            ctR=0;
        }
        return ans;
    }
}