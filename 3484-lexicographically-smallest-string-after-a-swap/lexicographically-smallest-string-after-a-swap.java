class Solution {
    public String getSmallestString(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        int i=0;
        for(i=0;i<n-1;i++){
            char c=s.charAt(i);
            int x=c-'0';
            char d=s.charAt(i+1);
            int y=d-'0';
            if(x%2==y%2){
                if(x>y){
                    sb.append(d);
                    sb.append(c);
                    break;
                }else{
                    sb.append(c);
                }
            }
            else sb.append(c);
        }
        if(i==n-1){}
        else
        i=i+2;
        while(i<n){
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}