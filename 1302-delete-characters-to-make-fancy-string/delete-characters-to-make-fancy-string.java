class Solution {
    public String makeFancyString(String s) {
        int n=s.length();
        String x=s.substring(0,1);
        int ct=1;

        char ch[]=s.toCharArray();
        StringBuilder sb=new StringBuilder(x);
        for(int i=1;i<n;i++){
            if(ch[i]==ch[i-1]){
                ct++;
            }
            else ct=1;
            
            if(ct<=2) sb.append(ch[i]);
        }
        return sb.toString();
    }
}