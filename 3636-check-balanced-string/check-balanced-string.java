class Solution {
    public boolean isBalanced(String num) {
        int a=0;
        int b=0;
        for(int i=0;i<num.length();i++){
            if(i%2==0) a+=Character.getNumericValue(num.charAt(i));
            else b+=Character.getNumericValue(num.charAt(i));
        }
        //System.out.println(a+" "+b);
        if(a==b) return true;
        else return false;
    }
}