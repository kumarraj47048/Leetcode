class Solution {
    public int addDigits(int num) {
        int lg=String.valueOf(num).length();
         if(lg==1) return num;
         int sum=0;
         while(num>0){
            sum+=num%10;
            num=num/10;
         }
         return addDigits(sum);
    }

    // public static int size(int num){
    //     int ct=0;
    //     while(num>0){
    //          ct++;
    //         num=num/10;
           
    //     }
    //     return ct;
    // }
}