class Solution {
    public String customSortString(String order, String s) {
        int n=order.length();
        int ch[]=new int[26];
        for(char c:s.toCharArray()){
            ch[c-'a']++;
        }
        StringBuilder sb=new StringBuilder("");
        for(char c:order.toCharArray()){
            if(ch[c-'a']>0){
                while(ch[c-'a']-->0)
                sb.append(c);
            }
            
        }
        for(char c:s.toCharArray()){
            if(ch[c-'a']>0){
                while(ch[c-'a']-->0)
                sb.append(c);
            }
        }
        return sb.toString();
    }
}