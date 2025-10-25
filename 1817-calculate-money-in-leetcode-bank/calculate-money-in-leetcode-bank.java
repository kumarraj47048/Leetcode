class Solution {
    public int totalMoney(int n) {
       int ct=0;
       int weeks=n/7;
       int extraDays=n%7;
       for(int i=1;i<=weeks;i++){
           ct+=(7)*(2*i +6)/2;
       }
        ct+=(extraDays)*(2*(weeks+1)+(extraDays-1))/2;
        
        return ct;
    }
}