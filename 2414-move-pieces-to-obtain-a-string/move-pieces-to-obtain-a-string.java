class Solution {
    public boolean canChange(String start, String target) {
       int n=start.length();
       int p1=0;
       int p2=0;
       while(p1<n || p2<n){
          
          
          while(p1<n && start.charAt(p1)=='_') p1++;
          while(p2<n && target.charAt(p2)=='_') p2++;

          if(p1==n || p2==n){
            return p1==n && p2==n;
          }
          //if(p1>=n || p2>=n) return false;
          if(p1<n && p2<n)
          if(start.charAt(p1)!=target.charAt(p2)) return false;
          if(p1<n)
          if(start.charAt(p1)=='L' ){
            if(p1<p2) return false;
          }
          if(p1<n)
          if(start.charAt(p1)=='R' ){
            if(p1>p2) return false;
          }
          p1++;
          p2++;
       }
       return true;
    }
}
