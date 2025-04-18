class Solution {
    public String countAndSay(int n) {
        String s="1";
        for(int i=2;i<=n;i++){
           // System.out.println(s);
            s=func(s);
        }
        //System.out.println(s);
        return s;
    }
    public static String func(String s){
        int ct=1;
        char c=s.charAt(0);
        StringBuilder sb=new StringBuilder("");
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==c){
                ct++;
            }else{
                sb.append(ct);
                sb.append(c);
                ct=1;
                c=ch;
            }
        }
        sb.append(ct);
        sb.append(c);

        return sb.toString();
    }
}