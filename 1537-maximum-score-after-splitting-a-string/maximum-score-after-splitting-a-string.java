class Solution {
    public int maxScore(String s) {
       int n=s.length();
       int ones=0;
       for(int i=0;i<n;i++){
           if(s.charAt(i)=='1') ones++;
       }

       int zeroes=0;
       int ans=0;
       for(int i=0;i<n-1;i++){
           if(s.charAt(i)=='1') ones--;
           else zeroes++;
           ans=Math.max(ans,ones+zeroes);
       }
       return ans;
    }
}