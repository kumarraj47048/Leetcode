class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ct=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='1') ct++;
        }
        StringBuilder sb=new StringBuilder("");
        int start=ct-1;
        int z=s.length()-ct;
        
        for(int i=0;i<s.length();i++){
            if(i>=0 && i<start) sb.append(1);
            else if(i>=start && i<s.length()-1) sb.append(0);
            else sb.append(1);
        }
        return sb.toString();
    }
}