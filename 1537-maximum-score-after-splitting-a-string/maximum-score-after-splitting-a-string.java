class Solution {
    public int maxScore(String s) {
        int n=s.length();
        if(n==2){
            if(s.equals("00") || s.equals("11")) return 1;
            else if(s.equals("01")) return 2;
            else return 0;
        }
        int pl[]=new int[n+1];
        int pr[]=new int[n+1];
        pr[n]=0;
        if(s.charAt(0)=='0') pl[0]=1;
        for(int i=1;i<n;i++){
            pl[i]=pl[i]+pl[i-1];
            if(s.charAt(i)=='0') pl[i]++;
        }

        for(int i=n-1;i>=0;i--){
            pr[i]=pr[i]+pr[i+1];
            if(s.charAt(i)=='1') pr[i]++;
        }
        int max=0;
        for(int i=1;i<n-1;i++){
            max=Math.max(max,pl[i]+pr[i]);
        }
        return max;
    }
}