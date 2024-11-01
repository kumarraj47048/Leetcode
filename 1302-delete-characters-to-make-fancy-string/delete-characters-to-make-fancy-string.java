class Solution {
    public String makeFancyString(String s) {
        if(s.length()<2) return s;
        char a=s.charAt(0);
        char b=s.charAt(1);
        StringBuilder sb=new StringBuilder("");
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for(int i=2;i<s.length();i++){
            char c=s.charAt(i);
            if(a!=b || b!=c){
                a=b;
                b=c;
                sb.append(c);
            }
            
        }
        return sb.toString();
    }
}