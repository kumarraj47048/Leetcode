class Solution {
    public String reverseWords(String s) {
        String regex="[,\\.\\s]";
        String x[]=s.split(regex);
        StringBuilder sb=new StringBuilder();
        for(int i=x.length-1;i>=0;i--){
           if(!x[i].trim().isEmpty())
           sb.append(x[i]+" ");
        }
        int idx=sb.length()-1;
        while(idx>=0 && sb.charAt(idx)==' ') idx--;
        return sb.toString().substring(0,idx+1);
    }
}