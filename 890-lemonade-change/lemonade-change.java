class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int a=0;
        int b=0;
        for(int i=0;i<n;i++){
            if(bills[i]==5) a++;
            else if(bills[i]==10){
                if(a<1) return false;
                else{
                    a--;
                    b++;
                }
            }
            else{
                if(b>0 && a>0){
                    b--;
                    a--;
                }
                else if(a>2){
                    a-=3;
                }
                else return false;
            }
        }
        return true;
    }
}