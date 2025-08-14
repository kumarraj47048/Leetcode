class Solution {
    public String largestGoodInteger(String num) {
        int n=num.length();
        String x="-1";
        char ch[]=num.toCharArray();
        for(int i=2;i<n;i++){
            if(ch[i]==ch[i-1] && ch[i-1]==ch[i-2]){
                if(Integer.parseInt(num.substring(i-2,i+1))>Integer.parseInt(x)) x=num.substring(i-2,i+1);
            }
        }
        if(x.equals("-1")) return "";
        return x;
    }
}